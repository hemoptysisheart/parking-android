package com.github.hemoptysisheart.parking.core.domain.common

import androidx.annotation.StringRes
import com.github.hemoptysisheart.parking.core.R
import com.github.hemoptysisheart.parking.domain.common.Type

enum class Types(
        @StringRes val label: Int
) : Type {
    RECOMMEND_ITEM_SEARCH_QUERY(R.string.domain_type_recommend_item_query),
    RECOMMEND_ITEM_PLACE(R.string.domain_type_recommend_item_place),
    RECOMMEND_ITEM_ROUTE(R.string.domain_type_recommend_item_route),
    PLACE(R.string.domain_type_place),
    QUERY(R.string.domain_type_query),
    ROUTE(R.string.domain_type_route);

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)
    }
}