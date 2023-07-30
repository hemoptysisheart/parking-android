package com.github.hemoptysisheart.parking.client.google.data

/**
 * [TravelMode](https://developers.google.com/maps/documentation/directions/get-directions#TravelMode)
 */
enum class TravelMode {
    /**
     * `DRIVING` (default) indicates calculation using the road network.
     */
    DRIVING,

    /**
     * `BICYCLING` requests calculation for bicycling via bicycle paths & preferred streets (where available).
     */
    BICYCLING,

    /**
     * `TRANSIT` requests calculation via public transit routes (where available).
     */
    TRANSIT,

    /**
     * `WALKING` requests calculation for walking via pedestrian paths & sidewalks (where available).
     */
    WALKING;

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)
    }
}
