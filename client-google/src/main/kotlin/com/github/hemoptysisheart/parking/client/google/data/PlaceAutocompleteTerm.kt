package com.github.hemoptysisheart.parking.client.google.data

/**
 * [PlaceAutocompleteTerm](https://developers.google.com/maps/documentation/places/web-service/autocomplete#PlaceAutocompleteTerm)
 */
data class PlaceAutocompleteTerm(
    /**
     * Defines the start position of this term in the description, measured in Unicode characters.
     */
    val offset: Int,
    /**
     * The text of the term.
     */
    val value: String
)
