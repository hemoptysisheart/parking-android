package com.github.hemoptysisheart.parking.core.extension

import com.github.hemoptysisheart.parking.core.client.google.data.DirectionsStep
import com.github.hemoptysisheart.parking.domain.deprecate.Maneuver
import com.github.hemoptysisheart.parking.domain.deprecate.NaviStep
import java.time.Duration

fun DirectionsStep.toNaviStep() = NaviStep(
    start = startLocation.location,
    end = endLocation.location,
    distance = distance?.number ?: 0.0,
    duration = Duration.ofSeconds(duration.number.toLong()),
    guideText = html,
    polyline = polyline.points.map { it.location },
    maneuver = maneuver?.name?.let { Maneuver.valueOf(it) }
)
