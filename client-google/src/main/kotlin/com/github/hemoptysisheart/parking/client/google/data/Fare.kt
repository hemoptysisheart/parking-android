package com.github.hemoptysisheart.parking.client.google.data

import java.util.*

/**
 * [Fare](https://developers.google.com/maps/documentation/directions/get-directions#Fare)
 *
 * The total fare for the route.
 */
data class Fare(
    /**
     * An [ISO 4217 currency code](https://en.wikipedia.org/wiki/ISO_4217) indicating the currency that the amount is
     * expressed in.
     */
    val currency: Currency,
    /**
     * The total fare amount, formatted in the requested language.
     */
    val text: String,
    /**
     * The total fare amount, in the currency specified.
     */
    val value: Long
)
