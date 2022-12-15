package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.dummy.model.DummyPlaceModel
import com.github.hemoptysisheart.parking.domain.Location
import com.google.android.libraries.places.api.model.Place.Field
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.PlacesClient
import java.util.*

class PlaceModelImpl(
    private val client: PlacesClient
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

        val request = FetchPlaceRequest.builder(
            query,
            listOf(
                Field.ID,
                Field.NAME,
                Field.LAT_LNG,
                Field.ADDRESS,
                Field.TYPES
            )
        ).build()
        Log.d(TAG, "#search : request=$request")
        val places = client.fetchPlace(request)
            .result
        Log.d(TAG, "#search : places=$places")
    }

    override fun toString() = "$TAG(client=$client, places=${places})"
}