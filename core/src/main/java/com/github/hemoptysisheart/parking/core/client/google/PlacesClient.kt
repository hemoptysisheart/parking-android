package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.dto.NearbyParams

/**
 * [Places API](https://console.cloud.google.com/apis/library/places-backend.googleapis.com)
 */
interface PlacesClient {
    suspend fun nearBy(params: NearbyParams)
}