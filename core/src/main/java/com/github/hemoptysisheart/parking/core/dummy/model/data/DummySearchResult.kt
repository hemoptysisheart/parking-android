package com.github.hemoptysisheart.parking.core.dummy.model.data

import com.github.hemoptysisheart.parking.core.dummy.model.data.DummySearchResultItem.GMP_0
import com.github.hemoptysisheart.parking.core.dummy.model.data.DummySearchResultItem.GMP_1
import com.github.hemoptysisheart.parking.core.dummy.model.data.DummySearchResultItem.GMP_2
import com.github.hemoptysisheart.parking.core.model.data.SearchResult

object DummySearchResult {
    val RESULT_0 = SearchResult(
        query = "新宿",
        listOf(GMP_0, GMP_1, GMP_2)
    )
}