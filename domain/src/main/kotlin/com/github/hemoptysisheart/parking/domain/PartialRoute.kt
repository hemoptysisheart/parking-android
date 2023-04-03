package com.github.hemoptysisheart.parking.domain

data class PartialRoute(
    val summary: String,
    val bounds: GeoBounds,
    val overview: List<GeoLocation>,
    val legList: List<NaviLeg>
)
