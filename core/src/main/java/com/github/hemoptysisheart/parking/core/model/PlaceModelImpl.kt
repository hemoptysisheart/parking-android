package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.dummy.model.DummyPlaceModel
import java.util.*

class PlaceModelImpl : PlaceModel {
    companion object {
        private val TAG = PlaceModelImpl::class.simpleName
    }

    override val places = DummyPlaceModel.places

    override suspend fun read(id: UUID) = places.firstOrNull { it.id == id }

    override suspend fun search(query: String) {
        Log.d(TAG, "#search args : query=$query")
    }

    override fun toString() = "$TAG(places=${places})"
}