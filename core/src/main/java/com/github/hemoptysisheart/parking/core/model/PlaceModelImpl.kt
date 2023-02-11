package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.client.google.PlacesClient
import com.github.hemoptysisheart.parking.core.client.google.dto.NearbySearchParams
import com.github.hemoptysisheart.parking.core.client.google.dto.RankBy
import com.github.hemoptysisheart.parking.core.logging.logArgs
import com.github.hemoptysisheart.parking.core.model.dto.PlaceSearchResult
import com.github.hemoptysisheart.parking.core.model.dto.RecommendItemGmpPlace
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.util.TimeProvider

class PlaceModelImpl(
    private val placesClient: PlacesClient,
    private val timeProvider: TimeProvider
) : PlaceModel {
    companion object {
        private val TAG = PlaceModelImpl::class.simpleName!!
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
        val apiResult = placesClient.nearBy(params, now)

        val result = PlaceSearchResult(
            center, query,
            apiResult.places.map { RecommendItemGmpPlace(it) },
            apiResult.nextToken
        )

        Log.v(TAG, "#searchDestination return : $result")
        return result
    }

    override fun toString() = "$TAG(placesClient=$placesClient, timeProvider=$timeProvider)"
}