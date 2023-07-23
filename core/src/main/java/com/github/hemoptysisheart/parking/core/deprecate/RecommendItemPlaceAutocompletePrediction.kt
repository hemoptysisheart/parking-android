package com.github.hemoptysisheart.parking.core.deprecate

import com.github.hemoptysisheart.parking.core.client.google.data.PlaceAutocompletePrediction
import com.github.hemoptysisheart.parking.domain.deprecate.RecommendItem

class RecommendItemPlaceAutocompletePrediction(
    val item: PlaceAutocompletePrediction
) : RecommendItem {
    companion object {
        private const val TAG = "RecommendItemPlaceAutocompletePrediction"
    }

    override val id = LocationGmpPlace.toId(item.placeId!!)

    override val summary = item.structuredFormatting.mainText

    override val detail = item.description

    override fun equals(other: Any?) = this === other ||
            other is RecommendItemPlaceAutocompletePrediction &&
            id == other.id

    override fun hashCode() = id.hashCode()

    override fun toString() = "$TAG(item=$item)"
}
