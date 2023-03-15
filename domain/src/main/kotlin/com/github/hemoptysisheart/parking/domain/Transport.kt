package com.github.hemoptysisheart.parking.domain

/**
 * 이동수단.
 */
enum class Transport {
    /**
     * 걷기
     */
    WALK,

    /**
     * 운전
     */
    DRIVE,

    /**
     * 자전거
     */
    BICYCLE,

    /**
     * 환승
     */
    TRANSIT;

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]
    }
}
