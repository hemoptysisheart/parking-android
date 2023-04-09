package com.github.hemoptysisheart.parking.domain

import java.time.Duration

data class NaviStep(
    val start: Location,
    val end: Location,
    /**
     * meter 단위.
     */
    val distance: Double,
    val duration: Duration,
    val guideText: String?,
    val polyline: List<GeoLocation>,
    val maneuver: Maneuver?
)
