package com.github.hemoptysisheart.parking.client.google.data

import java.util.Locale

data class PlaceParams(
        val placeId: String,
        val fields: List<Field>? = null,
        val language: Locale? = null,
        val region: String? = null,
        val reviewsNoTranslations: Boolean? = null,
        val reviewsSort: ReviewSort? = null,
        val sessionToken: String? = null
) {
    init {
        when {
            placeId.isEmpty() ->
                throw IllegalArgumentException("placeId is empty.")
        }
    }
}
