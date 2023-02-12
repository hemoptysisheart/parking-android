package com.github.hemoptysisheart.parking.core.model.dto

import com.github.hemoptysisheart.parking.domain.RecommendItem

/**
 * Google Places API 검색 결과용 추천 정보.
 */
class RecommendItemGmpPlace(
    override val item: LocationGmpPlace
) : RecommendItem<LocationGmpPlace> {
    companion object {
        private val TAG = RecommendItemGmpPlace::class.simpleName!!
    }

    override val id = item.id

    override val summary = item.name

    override val detail = item.description

    override fun equals(other: Any?) = this === other ||
            null != other &&
            other is RecommendItemGmpPlace &&
            id == other.id

    override fun hashCode() = id.hashCode()

    override fun toString() = "$TAG(id=$id, summary='$summary', detail=$detail, item=$item)"
}