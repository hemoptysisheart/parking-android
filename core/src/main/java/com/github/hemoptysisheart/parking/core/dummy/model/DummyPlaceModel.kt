package com.github.hemoptysisheart.parking.core.dummy.model

import com.github.hemoptysisheart.parking.core.dummy.domain.DummyPlace
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.domain.Place
import java.util.*

object DummyPlaceModel : PlaceModel {
    override var places: List<Place> = listOf(DummyPlace.PLACE1, DummyPlace.PLACE2, DummyPlace.PLACE3)

    override suspend fun read(id: UUID): Place? = places.firstOrNull { it.id == id }

    override suspend fun search(query: String) {}
}