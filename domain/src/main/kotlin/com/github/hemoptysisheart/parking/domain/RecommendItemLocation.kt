package com.github.hemoptysisheart.parking.domain

class RecommendItemLocation(
    override val item: Location
) : RecommendItem<Location> {
    override val id = item.id

    override val summary = item.name

    override val detail = item.description

    override fun equals(other: Any?) = this === other ||
            other is RecommendItemLocation &&
            id == other.id

    override fun hashCode() = id.hashCode()

    override fun toString() = "RecommendItemLocation(id='$id', summary='$summary', detail=$detail, item=$item)"
}