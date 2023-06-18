package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.client.google.*
import com.github.hemoptysisheart.parking.core.client.google.data.AutocompleteParams.Companion.RADIUS_DEFAULT
import com.github.hemoptysisheart.parking.core.client.google.data.*
import com.github.hemoptysisheart.parking.core.client.google.data.PlaceTypeResultOnly.POINT_OF_INTEREST
import com.github.hemoptysisheart.parking.core.extension.toPartialRoute
import com.github.hemoptysisheart.parking.core.model.data.*
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.*
import com.github.hemoptysisheart.util.TimeProvider
import java.time.Instant
import java.util.*

class LocationModelImpl(
    private val mapsClient: MapsClient,
    private val timeProvider: TimeProvider
) : LocationModel {
    companion object {
        private const val TAG = "GeoSearchModelImpl"
        private val LOGGER = Logger(TAG)

        /**
         * 목적지 주변 주차장 검색 반경 기본값. meter 단위.
         */
        const val SEARCH_PARKING_RADIUS = 100

        val TRANSPORTATION_MODE_MAP = mapOf(
            TransportationMode.WALKING to Transport.WALK,
            TransportationMode.DRIVING to Transport.DRIVE,
            TransportationMode.BICYCLING to Transport.BICYCLE,
            TransportationMode.TRANSIT to Transport.TRANSIT
        )
    }

    /**
     * `Map<location_id, place>`
     */
    private val locationCache = mutableMapOf<String, Location>()

    private val routeCache = mutableMapOf<UUID, Route>()

    override suspend fun read(id: String): Location? {
        LOGGER.v("#read args : id=$id")

        if (!locationCache.containsKey(id)) {
            locationCache[id] = LocationGmpPlace(
                mapsClient.place(
                    PlaceParams(
                        LocationGmpPlace.toPlaceId(id)
                    )
                ).place
            )
        }
        val location = locationCache[id]

        LOGGER.v("#read return: $location")
        return location
    }

    override suspend fun searchDestination(center: GeoLocation, query: String): DestinationSearchResult {
        LOGGER.v("#searchDestination args : query=#query")

        val now = timeProvider.instant()
        val params = AutocompleteParams(
            input = query,
            radius = RADIUS_DEFAULT,
            location = LatLng(center.latitude, center.longitude),
            locationBias = IpBias,
            types = listOf(POINT_OF_INTEREST)
        )
        val resp = mapsClient.autocomplete(params, now)
        val result = DestinationSearchResult(
            center = center,
            query = query,
            predictionList = resp.predictions.map { RecommendItemPlaceAutocompletePrediction(it) }
        )

        LOGGER.v("#searchDestination return : $result")
        return result
    }

    override suspend fun searchParking(destination: Location): PlaceSearchResult {
        LOGGER.v("#searchParking args : destination=$destination")

        val now = timeProvider.instant()
        val params = NearbySearchParams(
            longitude = destination.longitude,
            latitude = destination.latitude,
            radius = SEARCH_PARKING_RADIUS,
            type = PlaceTypes.PARKING
        )
        val apiResult = mapsClient.nearBy(params, now)
        Log.v(TAG, "#searchParking : apiResult=$apiResult")

        val result = PlaceSearchResult(
            GeoLocation(destination.latitude, destination.longitude),
            null,
            apiResult.places.map { RecommendItemLocation(LocationGmpPlace(it)) },
            apiResult.nextToken
        )

        LOGGER.v("#searchParking return : $result")
        return result
    }

    private fun Location.toPlaceDescriptor() = when (this) {
        is LocationGmpPlace ->
            PlaceIdDescriptor(place.placeId!!)
        else ->
            LatLngDescriptor(LatLng(latitude, longitude))
    }

    override suspend fun searchRoute(
        origin: Location,
        destination: Location,
        mode: TransportationMode
    ): RouteSearchResult {
        LOGGER.v("#searchRoute args : origin=$origin, destination=$destination, mode=$mode")

        val now = Instant.now()
        val params = DirectionsParams(
            origin = origin.toPlaceDescriptor(),
            destination = destination.toPlaceDescriptor(),
            alternatives = false,
            transportationMode = mode
        )
        val result = mapsClient.directions(params, now)

        val route = RouteSearchResult(
            origin = origin,
            destination = destination,
            transport = TRANSPORTATION_MODE_MAP[mode]!!,
            partialRouteList = result.routes.map { it.toPartialRoute() }
        )
        LOGGER.v("#searchRoute return : $route")
        return route
    }

    override suspend fun searchRoute(origin: Location, destination: Location): List<Route> {
        LOGGER.v("#searchRoute args : origin=$origin, destination=$destination")
        val routeList = searchParking(destination).places.map {
            val route = Route(UUID.randomUUID(), origin, it.item, destination)
            routeCache[route.id] = route
            route
        }

        LOGGER.v("#searchRoute return : $routeList")
        return routeList
    }

    override suspend fun read(id: UUID): Route? {
        LOGGER.v("#searchRoute args : id=$id")

        val route = routeCache[id]
            ?: return null

        if (null == route.driving) {
            LOGGER.w("#searchRoute route.driving is null : route=$route")
            route.driving = searchRoute(route.origin, route.parking, TransportationMode.DRIVING)
                .partialRouteList[0]
        }
        if (null == route.walking) {
            LOGGER.w("#searchRoute route.walking is null : route=$route")
            route.walking = searchRoute(route.parking, route.destination, TransportationMode.WALKING)
                .partialRouteList[0]
        }

        LOGGER.v("#searchRoute return : $route")
        return route
    }

    override fun toString() = "$TAG(placesClient=$mapsClient, timeProvider=$timeProvider)"
}
