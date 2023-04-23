package com.github.hemoptysisheart.parking.core.model.data

import com.github.hemoptysisheart.parking.core.client.google.data.PlaceAutocompletePrediction
import com.github.hemoptysisheart.parking.domain.Location

class LocationGmpAutocompletePrediction(
    @Suppress("MemberVisibilityCanBePrivate")
    val prediction: PlaceAutocompletePrediction
) : Location {
    companion object {
        private const val TAG = "LocationGmpAutocompletePrediction"
    }

    override val id = prediction.placeId
        ?: throw IllegalArgumentException("placeId is null.")

    override val name = prediction.structuredFormatting.mainText

    override val description = prediction.description

    override var latitude = 0.0

    override var longitude = 0.0

    override fun hashCode() = prediction.hashCode()

    override fun toString() = "$TAG(prediction=$prediction)"
}
