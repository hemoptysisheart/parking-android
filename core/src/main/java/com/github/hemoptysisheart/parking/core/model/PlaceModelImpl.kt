package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.client.google.NearbyParams
import com.github.hemoptysisheart.parking.core.client.google.PlaceType
import com.github.hemoptysisheart.parking.core.client.google.PlacesClient
import com.github.hemoptysisheart.parking.core.dummy.model.DummyPlaceModel
import com.github.hemoptysisheart.parking.domain.Location
import java.util.*

class PlaceModelImpl(
    private val placesClient: PlacesClient
) : PlaceModel {
    companion object {
        private val TAG = PlaceModelImpl::class.simpleName
    }

    /**
     * TODO 캐시로 변환.
     */
    override val places = DummyPlaceModel.places

    override suspend fun read(id: UUID) = places.firstOrNull { it.id == id }

    override suspend fun search(query: String, location: Location) {
        Log.d(TAG, "#search args : query=$query, location=$location")

        val params = NearbyParams(
            longitude = location.longitude,
            latitude = location.latitude,
            keyword = query,
            types = setOf(PlaceType.PARKING)
        )
        placesClient.nearBy(params)
    }

    override fun toString() = "$TAG(, places=${places})"
}