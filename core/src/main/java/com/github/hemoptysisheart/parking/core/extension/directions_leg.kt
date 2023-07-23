package com.github.hemoptysisheart.parking.core.extension

import com.github.hemoptysisheart.parking.core.client.google.data.DirectionsLeg
import com.github.hemoptysisheart.parking.domain.deprecate.NaviLeg

fun DirectionsLeg.toNaviLeg() = NaviLeg(
    start = startLocation.location,
    end = endLocation.location,
    distance = distance?.number,
    stepList = steps.map { it.toNaviStep() }
)
