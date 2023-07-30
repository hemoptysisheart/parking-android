package com.github.hemoptysisheart.parking.core.client.google.data


data class WaypointDescriptor(
    val placeId: String? = null,
    val location: LatLng? = null,
    val address: String? = null,
    val polyline: List<LatLng>? = null
) {
    init {
        when {
            placeId.isNullOrEmpty() && null == location && address.isNullOrEmpty() && null == polyline ->
                throw IllegalArgumentException("all properties are null or empty.")
        }
    }
}
