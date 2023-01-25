package com.github.hemoptysisheart.parking.domain

/**
 * 지리적 좌표.
 */
interface GeoLocation {
    /**
     * 위도. -90.0 ~ 90.0
     */
    val latitude: Double

    /**
     * 경도. -180.0 ~ 180.0
     */
    val longitude: Double
}