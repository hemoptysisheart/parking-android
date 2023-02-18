package com.github.hemoptysisheart.parking.core.client.google.dto

/**
 * [DirectionsTransitStop](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitStop)
 */
data class DirectionsTransitStop(
    /**
     * The location of the stop.
     *
     * See [LatLngLiteral](https://developers.google.com/maps/documentation/directions/get-directions#LatLngLiteral)
     * for more information.
     */
    val location: LatLng,
    /**
     * The name of the transit stop.
     */
    val name: String
)