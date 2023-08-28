package com.github.hemoptysisheart.parking.domain.route

import com.github.hemoptysisheart.parking.domain.place.Geolocation

/**
 * 경로 도중에 있는 경유 위치.
 */
interface Waypoint {
    /**
     * 좌표
     */
    val geolocation: Geolocation
}
