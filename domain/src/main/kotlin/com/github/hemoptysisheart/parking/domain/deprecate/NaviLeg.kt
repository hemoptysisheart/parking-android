package com.github.hemoptysisheart.parking.domain.deprecate

data class NaviLeg(
    val start: Location,
    val end: Location,
    val distance: Double?,
    val stepList: List<NaviStep>
)
