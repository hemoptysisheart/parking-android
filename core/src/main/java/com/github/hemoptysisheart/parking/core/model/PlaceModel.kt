package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.search.Query

interface PlaceModel {
    suspend fun searchDestination(query: Query): List<Place>
}