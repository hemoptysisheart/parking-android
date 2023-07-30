package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceAutocompleteMatchedSubstring](https://developers.google.com/maps/documentation/places/web-service/autocomplete#PlaceAutocompleteMatchedSubstring)
 */
data class PlaceAutocompleteMatchedSubstringResp(
    /**
     * Length of the matched substring in the prediction result text.
     */
    @SerializedName("length")
    var length: Int? = null,
    /**
     * Start location of the matched substring in the prediction result text.
     */
    @SerializedName("offset")
    var offset: Int? = null
)
