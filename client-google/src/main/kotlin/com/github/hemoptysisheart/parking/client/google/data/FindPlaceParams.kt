package com.github.hemoptysisheart.parking.client.google.data

import java.util.Locale

/**
 * [Find Place](https://developers.google.com/maps/documentation/places/web-service/search-find-place)용 인자.
 */
data class FindPlaceParams(
        val input: String,
        val inputType: InputType,
        val fields: List<Field>? = null,
        val language: Locale? = null,
        val locationBias: LocationBias? = null
)
