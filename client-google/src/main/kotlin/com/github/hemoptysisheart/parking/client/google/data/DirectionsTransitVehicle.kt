package com.github.hemoptysisheart.parking.client.google.data

import java.net.URL

/**
 * [DirectionsTransitVehicle](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitVehicle)
 */
data class DirectionsTransitVehicle(
        /**
         * The name of this vehicle, capitalized.
         */
        var name: String,
        /**
         * The type of vehicle used.
         */
        var type: VehicleType,
        /**
         * Contains the URL for an icon associated with this vehicle type.
         */
        var icon: URL? = null,
        /**
         * Contains the URL for the icon associated with this vehicle type, based on the local transport signage.
         */
        var localIcon: URL? = null
)
