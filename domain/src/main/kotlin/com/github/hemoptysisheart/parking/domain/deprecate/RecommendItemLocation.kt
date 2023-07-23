package com.github.hemoptysisheart.parking.domain.deprecate

class RecommendItemLocation(
    val item: Location
) : RecommendItem {
    override val id = item.id

    override val summary = item.name

    override val detail = item.description

    var distance = 0.0
        private set

    override fun equals(other: Any?) = this === other ||
            other is RecommendItemLocation &&
            id == other.id

    override fun hashCode() = id.hashCode()

    override fun toString() = "RecommendItemLocation(id='$id', summary='$summary', detail=$detail, item=$item)"
}
