package com.github.hemoptysisheart.parking.core.client.google.dto

/**
 * The type of vehicle.
 *
 * See [DirectionsTransitVehicle](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitVehicle)
 */
enum class VehicleType {
    /**
     * Bus.
     */
    BUS,

    /**
     * A vehicle that operates on a cable, usually on the ground. Aerial cable cars may be of the type `GONDOLA_LIFT`.
     */
    CABLE_CAR,

    /**
     * Commuter rail.
     */
    COMMUTER_TRAIN,

    /**
     * Ferry.
     */
    FERRY,

    /**
     * A vehicle that is pulled up a steep incline by a cable. A Funicular typically consists of two cars, with each
     * car acting as a counterweight for the other.
     */
    FUNICULAR,

    /**
     *  An aerial cable car.
     */
    GONDOLA_LIFT,

    /**
     * Heavy rail.
     */
    HEAVY_RAIL,

    /**
     * High speed train.
     */
    HIGH_SPEED_TRAIN,

    /**
     * Intercity bus.
     */
    INTERCITY_BUS,

    /**
     * Long distance train.
     */
    LONG_DISTANCE_TRAIN,

    /**
     * Light rail transit.
     */
    METRO_RAIL,

    /**
     * Monorail.
     */
    MONORAIL,

    /**
     * All other vehicles will return this type.
     */
    OTHER,

    /**
     * Rail.
     */
    RAIL,

    /**
     * Share taxi is a kind of bus with the ability to drop off and pick up passengers anywhere on its route.
     */
    SHARE_TAXI,

    /**
     * Underground light rail.
     */
    SUBWAY,

    /**
     * Above ground light rail.
     */
    TRAM,

    /**
     * Trolleybus.
     */
    TROLLEYBUS;

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]
    }
}
