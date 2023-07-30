package com.github.hemoptysisheart.parking.domain.search

/**
 * 검색 결과.
 */
interface RecommendItem<T> {
    /**
     * 결과 이름
     */
    val name: String

    /**
     * 결과 설명
     */
    val description: String?

    val item: T
}
