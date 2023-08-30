package com.github.hemoptysisheart.parking.core.domain.common

import androidx.annotation.StringRes
import com.github.hemoptysisheart.parking.core.R
import com.github.hemoptysisheart.parking.domain.common.Type

enum class Types(
        @StringRes val label: Int,
        override val hostname: String
) : Type {
    RECOMMEND_ITEM_SEARCH_QUERY(R.string.domain_type_recommend_item_query, "recommendItemSearchQuery"),
    RECOMMEND_ITEM_PLACE(R.string.domain_type_recommend_item_place, "recommendItemPlace"),
    RECOMMEND_ITEM_ROUTE(R.string.domain_type_recommend_item_route, "recommendItemRoute"),
    PLACE_GMP(R.string.domain_type_place_gmp, "placeGmp"),
    QUERY(R.string.domain_type_query, "query"),
    SUB_ROUTE(R.string.domain_type_sub_route, "subRoute"),
    ROUTE(R.string.domain_type_route, "route");

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)

        fun ofHost(hostname: String) = values().first { it.hostname == hostname }
    }
}