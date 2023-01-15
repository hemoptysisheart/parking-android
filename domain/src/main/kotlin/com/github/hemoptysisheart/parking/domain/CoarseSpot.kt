package com.github.hemoptysisheart.parking.domain

import java.util.*

/**
 * 대략적 장소
 */
interface CoarseSpot : Place1 {
    override val level: PlaceLevel
        get() = PlaceLevel.COARSE_SPOT

    /**
     * 국가
     */
    val country: Locale

    /**
     * 우편번호
     */
    val zipCode: String

    /**
     * 대략적 주소
     */
    val address: String

    /**
     * 해당하는 장소.
     */
    val spots: List<Spot>
}