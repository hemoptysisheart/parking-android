package com.github.hemoptysisheart.parking.core.model.dto

import com.github.hemoptysisheart.parking.core.client.google.dto.PlaceDto
import com.github.hemoptysisheart.parking.domain.RecommendItem

class RecommendItemGmpPlace(
    override val item: PlaceDto
) : RecommendItem<PlaceDto> {
    companion object {
        val ID_PREFIX = "${PlaceDto::class.simpleName!!}:"
    }

    override val id = ID_PREFIX + item.placeId

    override val summary: String = ""

    override val detail: String? = ""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        return other is RecommendItemGmpPlace &&
                id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString() =
        "${RecommendItemGmpPlace::class.simpleName}(id='$id', summary='$summary', detail=$detail, item=$item)"
}