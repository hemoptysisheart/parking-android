package com.github.hemoptysisheart.parking.core.dummy.model

import com.github.hemoptysisheart.parking.core.dummy.domain.DummyPlace
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.domain.Place
import java.util.*

object DummyPlaceModel : PlaceModel {
    override val places: List<Place> = listOf(
        DummyPlace.PLACE
    )

    override fun read(id: UUID): Place? = places.firstOrNull { it.id == id }
}