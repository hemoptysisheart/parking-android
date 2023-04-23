package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.data.PlaceAutocompletePrediction
import com.github.hemoptysisheart.parking.core.client.google.data.PlacesAutocompleteStatus
import com.github.hemoptysisheart.parking.core.client.google.data.ResultMeta

/**
 * Google Maps Platform Place Autocomplete API response.
 */
data class AutocompleteResult(
    val meta: ResultMeta<AutocompleteParams>,
    val predictions: List<PlaceAutocompletePrediction>,
    val status: PlacesAutocompleteStatus,
    val errorMessage: String?,
    val infoMessages: List<String>?
)
