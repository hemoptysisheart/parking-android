package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.dummy.model.DummyPlaceModel
import java.util.*

class PlaceModelImpl : PlaceModel {
    companion object {
        private val TAG = PlaceModelImpl::class.simpleName
    }

    override val places = DummyPlaceModel.places

    override fun read(id: UUID) = places.firstOrNull { it.id == id }

    override fun toString() = "$TAG(places=${places})"
}