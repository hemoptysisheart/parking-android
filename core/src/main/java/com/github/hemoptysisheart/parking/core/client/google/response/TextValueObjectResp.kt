package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [TextValueObject](https://developers.google.com/maps/documentation/directions/get-directions#TextValueObject)
 *
 * An object containing a numeric value and its formatted text representation.
 */
data class TextValueObjectResp(
    /**
     * String value.
     */
    @SerializedName("text")
    var text: String? = null,
    /**
     * Numeric value.
     */
    @SerializedName("value")
    var value: Double? = null
)
