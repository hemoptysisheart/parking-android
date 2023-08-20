package com.github.hemoptysisheart.parking.client.google

import java.net.URL
import java.util.*

@Suppress("MemberVisibilityCanBePrivate")
class PlacesClientConfig(
        /**
         * Places API 키.
         */
        val key: String,

        val endpoint: URL = URL(DEFAULT_ENDPOINT),
        val debug: Boolean = false
) {
    companion object {
        const val DEFAULT_ENDPOINT = "https://maps.googleapis.com"
    }

    init {
        if (key.isEmpty()) {
            throw IllegalArgumentException("key is empty.")
        }
    }

    override fun toString() = "PlacesClientConfig(key=[ PROTECTED ], endpoint=$endpoint, debug=$debug)"
}
