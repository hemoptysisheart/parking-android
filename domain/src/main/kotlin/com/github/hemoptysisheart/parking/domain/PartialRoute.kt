package com.github.hemoptysisheart.parking.domain

data class PartialRoute(
    val summary: String,
    val bounds: GeoBounds,
    val overview: List<GeoLocation>,
    val legList: List<NaviLeg>  // TODO 여러개인 경우가 있는지 확인하기.
) {
    val distance: Double? = legList[0].distance
}
