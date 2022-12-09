package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.dummy.model.DummyPlaceModel
import com.google.android.libraries.places.api.model.Place.Field
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.ktx.api.net.awaitFetchPlace
import java.util.*

class PlaceModelImpl(
    private val client: PlacesClient
) : PlaceModel {
    companion object {
        private val TAG = PlaceModelImpl::class.simpleName
    }

    override val places = DummyPlaceModel.places

    override suspend fun read(id: UUID) = places.firstOrNull { it.id == id }

    override suspend fun search(query: String) {
        Log.d(TAG, "#search args : query=$query")

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
        val places = client.awaitFetchPlace(request)
        Log.d(TAG, "#search : places=$places")
    }

    override fun toString() = "$TAG(places=${places})"
}