package com.github.hemoptysisheart.parking.domain.place

import com.github.hemoptysisheart.parking.domain.common.Object

/**
 * 장소
 */
interface Place : Object {
    /**
     * 이름
     */
    val name: String

    /**
     * 주소
     */
    val address: String

    /**
     * 좌표
     */
    val geolocation: Geolocation
}
