package com.github.hemoptysisheart.parking.domain

import com.github.hemoptysisheart.util.Creatable
import java.util.*

/**
 * 검색 기록
 */
interface SearchLog : Creatable {
    val id: UUID

    /**
     * 검색 쿼리.
     */
    val query: String

    /**
     * 사용자가 선택한 어떤 장소.
     */
    val selected: Place
}