package com.github.hemoptysisheart.parking.core.model.data

import com.github.hemoptysisheart.parking.core.client.google.data.Place
import com.github.hemoptysisheart.parking.domain.RecommendItem

class RecommendItemPlace(
    val place: Place
) : RecommendItem {
    override val id = "RecommendItemPlace/${place.placeId}"

    override val summary: String = place.name
        ?: place.formattedAddress
        ?: place.vicinity
        ?: place.geometry?.location.toString()

    override val detail: String = ""
}