package com.github.hemoptysisheart.parking.app.domain

import com.github.hemoptysisheart.parking.domain.Location


/**
 * @return meter
 */
fun Location.distance(to: Location): Double {
    val result = FloatArray(3)
    android.location.Location.distanceBetween(
        latitude,
        longitude,
        to.latitude,
        to.longitude,
        result
    )
    return result[0].toDouble()
}
