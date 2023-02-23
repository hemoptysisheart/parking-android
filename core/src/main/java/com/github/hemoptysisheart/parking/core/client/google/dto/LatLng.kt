package com.github.hemoptysisheart.parking.core.client.google.dto

data class LatLng(
    val latitude: Double,
    val longitude: Double
) {
    init {
        if (latitude < -90.0 || 90.0 < latitude) {
            throw IllegalArgumentException("out of latitude range : latitude=$latitude")
        }
        if (longitude < -180.0 || 180.0 < longitude) {
            throw IllegalArgumentException("out of longitude range : longitude=$longitude")
        }
    }

    override fun toString() = "$latitude,$longitude"
}
