package com.github.hemoptysisheart.parking.domain.place

import com.github.hemoptysisheart.parking.domain.common.Object
import com.github.hemoptysisheart.parking.domain.route.Waypoint

/**
 * 장소
 */
interface Place : Object, Waypoint {
    val type: PlaceType

    /**
     * 이름
     */
    val name: String

    /**
     * 주소
     */
    val address: String
}
