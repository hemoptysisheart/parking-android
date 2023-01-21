package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.model.data.SearchResult
import com.github.hemoptysisheart.parking.domain.Coordinate
import com.github.hemoptysisheart.parking.domain.Place1
import java.util.*

interface PlaceModel {
    val places: List<Place1>

    suspend fun read(id: UUID): Place1?

    suspend fun search(query: String, location: Coordinate): SearchResult
}
