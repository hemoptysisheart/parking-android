package com.github.hemoptysisheart.parking.client.google

import com.github.hemoptysisheart.parking.client.google.data.AutocompleteParams
import com.github.hemoptysisheart.parking.client.google.data.DirectionsParams
import com.github.hemoptysisheart.parking.client.google.data.DirectionsRoute
import com.github.hemoptysisheart.parking.client.google.data.NearbySearchParams
import com.github.hemoptysisheart.parking.client.google.data.Place
import com.github.hemoptysisheart.parking.client.google.data.PlaceAutocompletePrediction
import com.github.hemoptysisheart.parking.client.google.data.PlaceParams

/**
 * [Places API](https://console.cloud.google.com/apis/library/places-backend.googleapis.com)
 */
interface MapsClient {
    /**
     * [Place Details](https://developers.google.com/maps/documentation/places/web-service/details)
     */
    suspend fun place(params: PlaceParams): Place?

    /**
     * [Place Autocomplete](https://developers.google.com/maps/documentation/places/web-service/autocomplete)
     */
    suspend fun autocomplete(params: AutocompleteParams): List<PlaceAutocompletePrediction>

    /**
     * [주변 지역 검색](https://developers.google.com/maps/documentation/places/web-service/search-nearby)
     */
    suspend fun nearBy(params: NearbySearchParams): List<Place>

    /**
     * [Directions API를 통해 경로 찾기](https://developers.google.com/maps/documentation/directions/get-directions)
     */
    suspend fun directions(params: DirectionsParams): List<DirectionsRoute>
}