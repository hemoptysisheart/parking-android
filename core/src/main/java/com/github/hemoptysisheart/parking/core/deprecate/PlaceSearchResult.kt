package com.github.hemoptysisheart.parking.core.deprecate

import com.github.hemoptysisheart.parking.domain.deprecate.GeoLocation
import com.github.hemoptysisheart.parking.domain.deprecate.RecommendItemLocation

data class PlaceSearchResult(
    val center: GeoLocation,
    val query: String?,
    val places: List<RecommendItemLocation>,
    val nextToken: String? = null
)
