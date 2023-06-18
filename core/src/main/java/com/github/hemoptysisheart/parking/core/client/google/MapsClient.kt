package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.data.*

/**
 * [Places API](https://console.cloud.google.com/apis/library/places-backend.googleapis.com)
 */
interface MapsClient {
    suspend fun place(params: PlaceParams): Place?

    suspend fun autocomplete(params: AutocompleteParams): List<PlaceAutocompletePrediction>

    suspend fun nearBy(params: NearbySearchParams): List<Place>

    suspend fun directions(params: DirectionsParams): List<DirectionsRoute>
}