package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.client.google.MapsClient
import com.github.hemoptysisheart.parking.core.client.google.data.*
import com.github.hemoptysisheart.parking.core.extension.toPartialRoute
import com.github.hemoptysisheart.parking.core.model.data.*
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItemLocation
import com.github.hemoptysisheart.parking.domain.Route
import java.util.*

class LocationModelImpl(
    private val mapsClient: MapsClient
) : LocationModel {
    companion object {
        private const val TAG = "LocationModelImpl"
        private val LOGGER = Logger(TAG)

        /**
         * 기본 목적지 검색 반경(100Km).
         */
        const val SEARCH_DESTINATION_RADIUS = 100_000

        /**
         * 목적지 주변 주차장 검색 반경 기본값(100m).
         */
        const val SEARCH_PARKING_RADIUS = 100
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
                place = mapsClient.place(PlaceParams(id.substring(RecommendItemPlace.ID_PREFIX.length)))
                    ?: throw IllegalArgumentException("place does not exist : placeId=${LocationGmpPlace.toPlaceId(id)}")
            )
        }
        val location = locationCache[id]

        LOGGER.v("#read return: $location")
        return location
    }

    override suspend fun searchDestination(center: GeoLocation, query: String): DestinationSearchResult {
        LOGGER.v("#searchDestination args : query=#query")

        val params = NearbySearchParams(
            longitude = center.longitude,
            latitude = center.latitude,
            radius = SEARCH_DESTINATION_RADIUS,
            keyword = query
        )
        val placeList = mapsClient.nearBy(params)
        val result = DestinationSearchResult(
            center = center,
            query = query,
            placeList = placeList.map { RecommendItemPlace(it) }
        )

        LOGGER.v("#searchDestination return : $result")
        return result
    }

    override suspend fun searchParking(destination: Location): PlaceSearchResult {
        LOGGER.v("#searchParking args : destination=$destination")

        val params = NearbySearchParams(
            longitude = destination.longitude,
            latitude = destination.latitude,
            radius = SEARCH_PARKING_RADIUS,
            type = PlaceTypes.PARKING
        )
        val places = mapsClient.nearBy(params)
        Log.v(TAG, "#searchParking : places=$places")

        val result = PlaceSearchResult(
            GeoLocation(destination.latitude, destination.longitude),
            null,
            places.map { RecommendItemLocation(LocationGmpPlace(it)) }
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

        val params = DirectionsParams(
            origin = origin.toPlaceDescriptor(),
            destination = destination.toPlaceDescriptor(),
            alternatives = false,
            transportationMode = mode
        )
        val routes = mapsClient.directions(params)

        val route = RouteSearchResult(
            origin = origin,
            destination = destination,
            transport = TransportMapping[mode],
            partialRouteList = routes.map { it.toPartialRoute() }
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

    override fun toString() = "$TAG(placesClient=$mapsClient)"
}
