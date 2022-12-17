package com.github.hemoptysisheart.parking.core.client.google

import java.net.URL

/**
 * [Places API](https://console.cloud.google.com/apis/library/places-backend.googleapis.com)
 */
interface PlacesClient {
    @Suppress("MemberVisibilityCanBePrivate")
    companion object {
        const val ENDPOINT_STRING = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"

        val ENDPOINT = URL(ENDPOINT_STRING)
    }

    fun nearBy(params: NearbyParams)
}