package com.github.hemoptysisheart.parking.core.deprecate

import com.github.hemoptysisheart.parking.core.client.google.data.Place
import com.github.hemoptysisheart.parking.domain.deprecate.RecommendItem

/**
 * Google Maps Platform 추천 장소.
 */
class RecommendItemPlace(
    val place: Place
) : RecommendItem {
    companion object {
        const val ID_PREFIX = "gmp:"
    }

    override val id = "$ID_PREFIX${place.placeId}"

    override var summary: String = ""
        private set

    override var detail: String = ""
        private set

    init {
        val candidates = listOfNotNull(
            place.name,
            place.formattedAddress,
            place.vicinity,
            place.geometry?.location.toString()
        )

        if (candidates.isNotEmpty()) {
            summary = candidates[0]
        }
        detail = if (1 < candidates.size) {
            candidates[1]
        } else {
            ""
        }
    }
}