package com.github.hemoptysisheart.parking.core.client.google.dto

import android.net.Uri

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
    var icon: Uri? = null,
    /**
     * Contains the URL for the icon associated with this vehicle type, based on the local transport signage.
     */
    var localIcon: Uri? = null
)
