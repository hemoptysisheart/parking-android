package com.github.hemoptysisheart.parking.domain.search

import com.github.hemoptysisheart.parking.domain.common.Object
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.util.NonNegativeInt

/**
 * 목적지 검색 쿼리.
 */
interface Query : Object {
    /**
     * 검색어.
     */
    val query: String?

    val center: Geolocation

    /**
     * 검색 반경.
     */
    val distance: NonNegativeInt
}
