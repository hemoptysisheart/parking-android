package com.github.hemoptysisheart.parking.domain.app

import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.parking.domain.common.Locale
import com.github.hemoptysisheart.util.NonNegativeInt

/**
 * 검색 설정
 */
interface SearchPreferences {
    companion object {
        const val DESTINATION_DISTANCE_MIN = 1
        const val DESTINATION_DISTANCE_MAX = 1_000_000
        val DESTINATION_DISTANCE_RANGE = DESTINATION_DISTANCE_MIN..DESTINATION_DISTANCE_MAX

        /**
         * 기본 목적지 검색 반경. meter 단위.
         */
        const val DESTINATION_DISTANCE_DEFAULT = 100_000

        const val PARKING_DISTANCE_MIN = 0
        const val PARKING_DISTANCE_MAX = 5_000
        val PARKING_DISTANCE_RANGE = PARKING_DISTANCE_MIN..PARKING_DISTANCE_MAX

        /**
         * 기본 목적지 주변 주차장 검색 반경. meter 단위.
         */
        const val PARKING_DISTANCE_DEFAULT = 200
    }

    /**
     * 검색 범위 설정
     */
    interface Distance {
        var enable: Boolean

        /**
         *
         */
        var distance: NonNegativeInt

        /**
         *
         */
        var unit: DistanceUnit
    }

    /**
     * 목적지 검색 설정.
     */
    val destination: Distance

    /**
     * 주차장 검색 설정
     */
    val parking: Distance

    /**
     * 검색 언어 설정
     */
    var language: Locale
}
