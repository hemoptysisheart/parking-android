package com.github.hemoptysisheart.parking.domain.app

import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.util.NonNegativeInt

interface QuerySetting {
    val distance: NonNegativeInt?

    val distanceUnit: DistanceUnit
}