package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.client.google.DirectionsParams
import com.github.hemoptysisheart.parking.core.client.google.MapsClient
import com.github.hemoptysisheart.parking.core.client.google.NearbySearchParams
import com.github.hemoptysisheart.parking.core.client.google.dto.*
import com.github.hemoptysisheart.parking.core.extension.toPartialRoute
import com.github.hemoptysisheart.parking.core.model.dto.LocationGmpPlace
import com.github.hemoptysisheart.parking.core.model.dto.PlaceSearchResult
import com.github.hemoptysisheart.parking.core.model.dto.RouteSearchResult
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItemLocation
import com.github.hemoptysisheart.parking.domain.Transport
import com.github.hemoptysisheart.util.TimeProvider
import java.time.Instant

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

    /**
     * TODO ID가 좌표이면 즉시 인스턴스 생성해서 반환하기.
     * TODO ID가 플레이스 ID이면 API에서 읽어서 캐시하고 반환하기.
     */
    override suspend fun read(id: String): Location? = locationCache[id]

    override suspend fun searchDestination(center: GeoLocation, query: String): PlaceSearchResult {
        LOGGER.v("#searchDestination args : query=#query")

        val now = timeProvider.instant()
        val params = NearbySearchParams(
            longitude = center.longitude,
            latitude = center.latitude,
            keyword = query,
            rankBy = RankBy.DISTANCE,
            type = PlaceTypeResultOnly.POINT_OF_INTEREST
        )
        val apiResult = mapsClient.nearBy(params, now)

        val result = PlaceSearchResult(
            center, query,
            apiResult.places.map { p ->
                val location = LocationGmpPlace(p)
                locationCache[location.id] = location
                RecommendItemLocation(location)
            },
            apiResult.nextToken
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
        is LocationGmpPlace -> PlaceDescriptor(placeId = place.placeId)
        else -> PlaceDescriptor(geoLocation = GeoLocation(latitude, longitude))
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

    override fun toString() = "$TAG(placesClient=$mapsClient, timeProvider=$timeProvider)"
}
