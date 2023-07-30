package com.github.hemoptysisheart.parking.domain.search

import com.github.hemoptysisheart.parking.domain.common.Object

/**
 * 검색어.
 */
interface Query : Object {
    /**
     * 검색어.
     */
    val query: String
}
