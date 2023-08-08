package com.github.hemoptysisheart.parking.domain.app

import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.util.NonNegativeInt

/**
 * 검색 설정
 */
interface SearchPreferences {
    companion object {
        /**
         * 기본 목적지 검색 반경. meter 단위.
         */
        const val DEFAULT_DESTINATION_DISTANCE = 100_000
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
    //val parking: Distance

    /**
     * 검색 언어 설정
     */
    //var language: Locale?
}
