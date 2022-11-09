package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.Place
import java.util.*

interface PlaceModel {
    val places: List<Place>

    fun read(id: UUID): Place?
}