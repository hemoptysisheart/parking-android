package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.dto.DirectionsParams
import com.github.hemoptysisheart.parking.core.client.google.dto.DirectionsSearchResult
import com.github.hemoptysisheart.parking.core.client.google.dto.NearbySearchParams
import com.github.hemoptysisheart.parking.core.client.google.dto.NearbySearchResult
import java.time.Instant

/**
 * [Places API](https://console.cloud.google.com/apis/library/places-backend.googleapis.com)
 */
interface PlacesClient {
    suspend fun nearBy(params: NearbySearchParams, requestAt: Instant): NearbySearchResult

    suspend fun directions(params: DirectionsParams, requestAt: Instant): DirectionsSearchResult
}