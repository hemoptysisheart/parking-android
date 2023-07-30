package com.github.hemoptysisheart.parking.domain.search

/**
 * 추천 검색어.
 */
interface RecommendItemQuery : RecommendItem<Query> {
    /**
     * 추천 검색어.
     */
    val query: Query
}