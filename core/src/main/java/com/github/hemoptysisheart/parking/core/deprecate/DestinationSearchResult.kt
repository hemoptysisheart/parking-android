package com.github.hemoptysisheart.parking.core.deprecate

import com.github.hemoptysisheart.parking.domain.deprecate.GeoLocation
import com.github.hemoptysisheart.parking.domain.deprecate.RecommendItem

data class DestinationSearchResult(
    val center: GeoLocation,
    val query: String,
    val placeList: List<RecommendItem>
)
