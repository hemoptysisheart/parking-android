package com.github.hemoptysisheart.parking.domain.search

import com.github.hemoptysisheart.parking.domain.common.Object

/**
 * 검색 결과.
 */
interface RecommendItem<T : Object> {
    /**
     * 결과 이름
     */
    val name: String

    /**
     * 결과 설명
     */
    val description: String?

    /**
     * 추천 아이템
     */
    val item: T
}
