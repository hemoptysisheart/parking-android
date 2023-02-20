package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.logging.logArgs
import com.github.hemoptysisheart.parking.core.model.dto.LocationGmpPlace
import com.github.hemoptysisheart.parking.core.model.dto.PlaceSearchResult
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItemLocation
import com.github.hemoptysisheart.util.TimeProvider
import com.google.maps.DirectionsApiRequest
import com.google.maps.GeoApiContext
import com.google.maps.NearbySearchRequest
import com.google.maps.model.LatLng
import com.google.maps.model.PlaceType
import com.google.maps.model.RankBy
import com.google.maps.model.TravelMode

class GeoSearchModelImpl(
    private val gmpContext: GeoApiContext,
    private val timeProvider: TimeProvider
) : GeoSearchModel {
    companion object {
        private const val TAG = "GeoSearchModelImpl"

        /**
         * 목적지 주변 주차장 검색 반경 기본값.
         */
        const val SEARCH_PARKING_RADIUS = 500
    }

    override suspend fun searchDestination(center: GeoLocation, query: String): PlaceSearchResult {
        logArgs(TAG, "searchDestination", "query" to query)

        val response = NearbySearchRequest(gmpContext)
            .location(LatLng(center.latitude, center.longitude))
            .keyword(query)
            .rankby(RankBy.DISTANCE)
            .await()

        val result = PlaceSearchResult(
            center, query,
            response.results.map { RecommendItemLocation(LocationGmpPlace(it)) },
            response.nextPageToken
        )

        Log.v(TAG, "#searchDestination return : $result")
        return result
    }

    override suspend fun searchParking(destination: Location): PlaceSearchResult {
        logArgs(TAG, "searchParking", "destination" to destination)

        val response = NearbySearchRequest(gmpContext)
            .location(LatLng(destination.latitude, destination.longitude))
            .radius(SEARCH_PARKING_RADIUS)
            .type(PlaceType.PARKING)
            .await()

        val result = PlaceSearchResult(
            destination.toGeoLocation(),
            null,
            response.results.map { RecommendItemLocation(LocationGmpPlace(it)) },
            response.nextPageToken
        )


        Log.v(TAG, "#searchParking return : $result")
        return result
    }

    override suspend fun searchPath(origin: Location, destination: Location, mode: TravelMode) {
        logArgs(TAG, "searchPath", "origin" to origin, "destination" to destination, "mode" to mode)

        val request = DirectionsApiRequest(gmpContext)
            .mode(mode)
        when (origin) {
            is LocationGmpPlace ->
                request.originPlaceId(origin.place.placeId)
            else ->
                request.origin(LatLng(origin.latitude, origin.longitude))
        }
        when (destination) {
            is LocationGmpPlace ->
                request.destinationPlaceId(destination.place.placeId)
            else ->
                request.destination(LatLng(destination.latitude, destination.longitude))
        }

        val result = request.await()
    }

    override fun toString() = "$TAG(gmpContext=$gmpContext, timeProvider=$timeProvider)"
}
