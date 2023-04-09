package com.github.hemoptysisheart.parking.domain

data class NaviLeg(
    val start: Location,
    val end: Location,
    val distance: Double?,
    val stepList: List<NaviStep>
)
