package com.github.hemoptysisheart.parking.core.model.data

import java.util.*

abstract class SearchResultItem(
    val id: UUID,
    val type: SearchResultItemType
) {
    abstract val name: String

    abstract val address: String

    override fun hashCode() = id.hashCode()

    override fun equals(other: Any?) = null != other &&
            this::class == other::class &&
            id == (other as SearchResultItem).id
}
