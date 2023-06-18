package com.github.hemoptysisheart.parking.core.model.data

import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.RecommendItem

data class DestinationSearchResult(
    val center: GeoLocation,
    val query: String,
    val placeList: List<RecommendItem>
)
