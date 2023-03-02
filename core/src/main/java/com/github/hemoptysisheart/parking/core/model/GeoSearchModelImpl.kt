package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.client.google.DirectionsParams
import com.github.hemoptysisheart.parking.core.client.google.MapsClient
import com.github.hemoptysisheart.parking.core.client.google.NearbySearchParams
import com.github.hemoptysisheart.parking.core.client.google.dto.PlaceDescriptor
import com.github.hemoptysisheart.parking.core.client.google.dto.PlaceTypes
import com.github.hemoptysisheart.parking.core.client.google.dto.RankBy
import com.github.hemoptysisheart.parking.core.client.google.dto.TransportationMode
import com.github.hemoptysisheart.parking.core.logging.logArgs
import com.github.hemoptysisheart.parking.core.model.dto.LocationGmpPlace
import com.github.hemoptysisheart.parking.core.model.dto.PlaceSearchResult
import com.github.hemoptysisheart.parking.core.model.dto.RouteSearchResult
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItemLocation
import com.github.hemoptysisheart.util.TimeProvider
import java.time.Instant

class GeoSearchModelImpl(
    private val mapsClient: MapsClient,
    private val timeProvider: TimeProvider
) : GeoSearchModel {
    companion object {
        private const val TAG = "GeoSearchModelImpl"

        /**
         * 목적지 주변 주차장 검색 반경 기본값. meter 단위.
         */
        const val SEARCH_PARKING_RADIUS = 200
    }

    override suspend fun searchDestination(center: GeoLocation, query: String): PlaceSearchResult {
        logArgs(TAG, "searchDestination", "query" to query)

        val now = timeProvider.instant()
        val params = NearbySearchParams(
            longitude = center.longitude,
            latitude = center.latitude,
            keyword = query,
            rankBy = RankBy.DISTANCE
        )
        val apiResult = mapsClient.nearBy(params, now)

        val result = PlaceSearchResult(
            center, query,
            apiResult.places.map { RecommendItemLocation(LocationGmpPlace(it)) },
            apiResult.nextToken
        )

        Log.v(TAG, "#searchDestination return : $result")
        return result
    }

    override suspend fun searchParking(destination: Location): PlaceSearchResult {
        logArgs(TAG, "searchParking", "destination" to destination)

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
            destination.toGeoLocation(),
            null,
            apiResult.places.map { RecommendItemLocation(LocationGmpPlace(it)) },
            apiResult.nextToken
        )

        Log.v(TAG, "#searchParking return : $result")
        return result
    }

    private fun Location.toPlaceDescriptor() = when (this) {
        is LocationGmpPlace -> PlaceDescriptor(placeId = place.placeId)
        else -> PlaceDescriptor(geoLocation = toGeoLocation())
    }

    override suspend fun searchRoute(
        origin: Location,
        destination: Location,
        mode: TransportationMode
    ): RouteSearchResult {
        logArgs(TAG, "searchRoute", "origin" to origin, "destination" to destination, "mode" to mode)

        val now = Instant.now()
        val params = DirectionsParams(
            origin = origin.toPlaceDescriptor(),
            destination = destination.toPlaceDescriptor(),
            transportationMode = mode
        )
        val result = mapsClient.directions(params, now)

        val route = RouteSearchResult(
            origin, destination, mode,
            result.routes[0]
        )
        Log.v(TAG, "#searchRoute return : $route")
        return route
    }

    override fun toString() = "$TAG(placesClient=$mapsClient, timeProvider=$timeProvider)"
}
