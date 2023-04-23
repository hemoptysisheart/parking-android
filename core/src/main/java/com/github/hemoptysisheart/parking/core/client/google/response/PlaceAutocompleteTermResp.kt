package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceAutocompleteTerm](https://developers.google.com/maps/documentation/places/web-service/autocomplete#PlaceAutocompleteTerm)
 */
data class PlaceAutocompleteTermResp(
    /**
     * Defines the start position of this term in the description, measured in Unicode characters.
     */
    @SerializedName("offset")
    var offset: Int? = null,
    /**
     * The text of the term.
     */
    @SerializedName("value")
    var value: String? = null
)
