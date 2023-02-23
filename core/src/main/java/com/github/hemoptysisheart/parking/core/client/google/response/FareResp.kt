package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [Fare](https://developers.google.com/maps/documentation/directions/get-directions#Fare)
 *
 * The total fare for the route.
 */
data class FareResp(
    /**
     * An [ISO 4217 currency code](https://en.wikipedia.org/wiki/ISO_4217) indicating the currency that the amount is
     * expressed in.
     */
    @SerializedName("currency")
    var currency: String? = null,
    /**
     * The total fare amount, formatted in the requested language.
     */
    @SerializedName("text")
    var text: String? = null,
    /**
     * The total fare amount, in the currency specified.
     */
    @SerializedName("value")
    var value: Long? = null
)
