package com.github.hemoptysisheart.parking.core.client.google.data

/**
 * [PlaceAutocompleteStructuredFormat](https://developers.google.com/maps/documentation/places/web-service/autocomplete#PlaceAutocompleteStructuredFormat)
 */
data class PlaceAutocompleteStructuredFormat(
    /**
     * Contains the main text of a prediction, usually the name of the place.
     */
    var mainText: String,
    /**
     * Contains an array with offset value and length. These describe the location of the entered term in the
     * prediction result text, so that the term can be highlighted if desired.
     */
    var mainTextMatchedSubstrings: List<PlaceAutocompleteMatchedSubstring>,
    /**
     * Contains the secondary text of a prediction, usually the location of the place.
     */
    var secondaryText: String? = null,
    /**
     * Contains an array with offset value and length. These describe the location of the entered term in the
     * prediction result text, so that the term can be highlighted if desired.
     */
    var secondaryTextMatchedSubstrings: List<PlaceAutocompleteMatchedSubstring>? = null
)
