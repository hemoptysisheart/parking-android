package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.data.Field
import com.github.hemoptysisheart.parking.core.client.google.data.ReviewSort
import java.util.*

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
