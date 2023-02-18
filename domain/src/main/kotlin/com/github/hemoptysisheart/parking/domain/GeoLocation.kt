package com.github.hemoptysisheart.parking.domain

import com.github.hemoptysisheart.util.RangeValidator
import com.github.hemoptysisheart.util.ToSimpleString

/**
 * 지리적 좌표.
 */
data class GeoLocation(
    /**
     * 위도. -90.0 ~ 90.0
     */
    val latitude: Double,

    /**
     * 경도. -180.0 ~ 180.0
     */
    val longitude: Double
) : ToSimpleString {
    companion object {
        val LATITUDE_VALIDATOR = RangeValidator(min = -90.0, max = 90.0, includeMin = true, includeMax = true)
        val LONGITUDE_VALIDATOR = RangeValidator(min = -180.0, max = 180.0, includeMin = true, includeMax = true)
    }

    init {
        LATITUDE_VALIDATOR.validate(latitude)
        LONGITUDE_VALIDATOR.validate(longitude)
    }

    override fun toSimpleString() = "$latitude,$longitude"
}
