package com.github.hemoptysisheart.parking.core.client.google.response

import com.github.hemoptysisheart.parking.core.client.google.dto.VehicleType
import com.google.gson.annotations.SerializedName

/**
 * [DirectionsTransitVehicle](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitVehicle)
 */
data class DirectionsTransitVehicleResp(
    /**
     * The name of this vehicle, capitalized.
     */
    @SerializedName("name")
    var name: String? = null,
    /**
     * The type of vehicle used.
     */
    @SerializedName("type")
    var type: VehicleType? = null,
    /**
     * Contains the URL for an icon associated with this vehicle type.
     */
    @SerializedName("icon")
    var icon: String? = null,
    /**
     * Contains the URL for the icon associated with this vehicle type, based on the local transport signage.
     */
    @SerializedName("local_icon")
    var localIcon: String? = null
)
