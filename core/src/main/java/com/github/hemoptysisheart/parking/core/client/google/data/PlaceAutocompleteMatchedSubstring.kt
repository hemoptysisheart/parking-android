package com.github.hemoptysisheart.parking.core.client.google.data

/**
 * [PlaceAutocompleteMatchedSubstring](https://developers.google.com/maps/documentation/places/web-service/autocomplete#PlaceAutocompleteMatchedSubstring)
 */
data class PlaceAutocompleteMatchedSubstring(
    /**
     * Length of the matched substring in the prediction result text.
     */
    val length: Int,
    /**
     * Start location of the matched substring in the prediction result text.
     */
    val offset: Int
)
