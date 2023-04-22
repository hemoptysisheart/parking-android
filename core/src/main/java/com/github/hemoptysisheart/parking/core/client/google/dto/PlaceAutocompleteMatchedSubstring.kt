package com.github.hemoptysisheart.parking.core.client.google.dto

/**
 * [PlaceAutocompleteMatchedSubstring](https://developers.google.com/maps/documentation/places/web-service/autocomplete#PlaceAutocompleteMatchedSubstring)
 */
data class PlaceAutocompleteMatchedSubstring(
    /**
     * Length of the matched substring in the prediction result text.
     */
    var length: Int,
    /**
     * Start location of the matched substring in the prediction result text.
     */
    var offset: Int
)
