package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceAutocompleteStructuredFormat](https://developers.google.com/maps/documentation/places/web-service/autocomplete#PlaceAutocompleteStructuredFormat)
 */
data class PlaceAutocompleteStructuredFormatResp(
    /**
     * Contains the main text of a prediction, usually the name of the place.
     */
    @SerializedName("main_text")
    var mainText: String? = null,
    /**
     * Contains an array with offset value and length. These describe the location of the entered term in the
     * prediction result text, so that the term can be highlighted if desired.
     */
    @SerializedName("main_text_matched_substrings")
    var mainTextMatchedSubstrings: List<PlaceAutocompleteMatchedSubstringResp>? = null,
    /**
     * Contains the secondary text of a prediction, usually the location of the place.
     */
    @SerializedName("secondary_text")
    var secondaryText: String? = null,
    /**
     * Contains an array with offset value and length. These describe the location of the entered term in the
     * prediction result text, so that the term can be highlighted if desired.
     */
    @SerializedName("secondary_text_matched_substrings")
    var secondaryTextMatchedSubstrings: List<PlaceAutocompleteMatchedSubstringResp>? = null
)
