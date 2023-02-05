package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.model.dto.PlaceSearchResult
import com.github.hemoptysisheart.parking.domain.GeoLocation

interface PlaceModel {
    suspend fun search(center: GeoLocation, query: String): PlaceSearchResult
}