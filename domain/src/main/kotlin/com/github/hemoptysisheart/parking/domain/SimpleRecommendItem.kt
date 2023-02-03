package com.github.hemoptysisheart.parking.domain

class SimpleRecommendItem<T>(
    override val id: String,
    override val item: T,
    override val summary: String = item.toString(),
    override val detail: String? = item.toString()
) : RecommendItem<T> {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SimpleRecommendItem<*>

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString() = "${SimpleRecommendItem::class.simpleName}(item=$item)"
}