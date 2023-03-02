package com.github.hemoptysisheart.parking.core.client.google.dto

import com.github.hemoptysisheart.parking.domain.GeoLocation

data class WaypointDescriptor(
    val placeId: String? = null,
    val location: GeoLocation? = null,
    val address: String? = null,
    val polyline: List<GeoLocation>? = null
) {
    init {
        when {
            placeId.isNullOrEmpty() && null == location && address.isNullOrEmpty() && null == polyline ->
                throw IllegalArgumentException("all properties are null or empty.")
        }
    }
}
