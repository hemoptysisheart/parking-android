package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.Place
import java.util.*

interface PlaceModel {
    val places: List<Place>

    suspend fun read(id: UUID): Place?

    suspend fun search(query: String)
}