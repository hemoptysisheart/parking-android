package com.github.hemoptysisheart.parking.domain.place

import com.github.hemoptysisheart.util.ToSimpleString

/**
 * 좌표
 */
data class Geolocation(
    /**
     * 위도
     */
    val latitude: Double,

    /**
     * 경도
     */
    val longitude: Double
) : ToSimpleString {
    @Suppress("MemberVisibilityCanBePrivate")
    companion object {
        const val LATITUDE_MIN = -90.0
        const val LATITUDE_MAX = 90.0
        val LATITUDE_RANGE = LATITUDE_MIN..LATITUDE_MAX

        const val LONGITUDE_MIN = -180.0
        const val LONGITUDE_MAX = 180.0
        val LONGITUDE_RANGE = LONGITUDE_MIN..LONGITUDE_MAX
    }

    init {
        if (!LATITUDE_RANGE.contains(latitude)) {
            throw IllegalArgumentException("out of range : latitude=$latitude, range=$LATITUDE_RANGE")
        }
        if (!LONGITUDE_RANGE.contains(longitude)) {
            throw IllegalArgumentException("out of range : longitude=$longitude, range=$LONGITUDE_RANGE")
        }
    }

    override fun toSimpleString() = "($latitude,$longitude)"
}