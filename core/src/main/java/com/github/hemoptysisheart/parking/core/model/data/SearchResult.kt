package com.github.hemoptysisheart.parking.core.model.data

class SearchResult(
    val query: String,
    val list: List<SearchResultItem>,
    val next: (suspend () -> SearchResult)? = null
) {
    val hasNext = null != next

    override fun toString() = "${SearchResult::class.simpleName}(list=$list, next=$next)"
}
