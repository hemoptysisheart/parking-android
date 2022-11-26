package com.github.hemoptysisheart.parking.domain

import com.github.hemoptysisheart.util.Creatable

/**
 * 앱 사용중 위치 정보.
 */
interface Location : Creatable {
    val id: Long

    /**
     * 위도
     */
    val latitude: Double

    /**
     * 경도
     */
    val longitude: Double
}