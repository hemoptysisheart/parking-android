package com.github.hemoptysisheart.parking.domain

import java.math.BigDecimal

/**
 * 위치 정보.
 */
interface Location {
    /**
     * 위도
     */
    val latitude: BigDecimal

    /**
     * 경도
     */
    val longitude: BigDecimal
}