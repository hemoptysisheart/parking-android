package com.github.hemoptysisheart.parking.core.domain.search

/**
 * 추천 검색어
 */
class RecommendItemQuery(
    override val query: Query
) : com.github.hemoptysisheart.parking.domain.search.RecommendItemQuery {
    override val item = query

    override val name: String = item.query

    override val description: String? = null

    override fun toString() = "RecommendItemQuery(query=$query)"
}
