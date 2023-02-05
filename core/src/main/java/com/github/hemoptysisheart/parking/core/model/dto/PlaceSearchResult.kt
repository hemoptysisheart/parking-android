package com.github.hemoptysisheart.parking.core.model.dto

import com.github.hemoptysisheart.parking.domain.GeoLocation

data class PlaceSearchResult(
    val center: GeoLocation,
    val query: String,
    val places: List<RecommendItemGmpPlace>
)
