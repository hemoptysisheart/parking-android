package com.github.hemoptysisheart.parking.domain

import com.github.hemoptysisheart.util.RangeValidator

/**
 * 위도, 경도 좌표.
 */
data class Coordinate(
    /**
     * 위도
     */
    val latitude: Double,
    /**
     * 경도
     */
    val longitude: Double
) {
    companion object {
        /**
         * 위도 검증기.
         */
        val LATITUDE_VALIDATOR = RangeValidator(min = -90.0, max = 90.0, includeMin = true, includeMax = true)

        /**
         * 경도 검증기
         */
        val LONGITUDE_VALIDATOR = RangeValidator(min = -180.0, max = 180.0, includeMin = true, includeMax = true)
    }

    init {
        LATITUDE_VALIDATOR.validate(latitude)
        LONGITUDE_VALIDATOR.validate(longitude)
    }

    override fun toString() = "$latitude,$longitude"
}