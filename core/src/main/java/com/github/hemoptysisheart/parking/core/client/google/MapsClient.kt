package com.github.hemoptysisheart.parking.core.client.google

import java.time.Instant

/**
 * [Places API](https://console.cloud.google.com/apis/library/places-backend.googleapis.com)
 */
interface MapsClient {
    suspend fun autocomplete(params: AutocompleteParams, requestAt: Instant): AutocompleteResult

    suspend fun nearBy(params: NearbySearchParams, requestAt: Instant): NearbySearchResult

    suspend fun directions(params: DirectionsParams, requestAt: Instant): DirectionsSearchResult
}