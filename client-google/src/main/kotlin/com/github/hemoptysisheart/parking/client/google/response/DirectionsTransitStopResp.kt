package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [DirectionsTransitStop](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitStop)
 */
data class DirectionsTransitStopResp(
        /**
         * The location of the stop.
         *
         * See [LatLngLiteral](https://developers.google.com/maps/documentation/directions/get-directions#LatLngLiteral)
         * for more information.
         */
        @SerializedName("location")
        var location: LatLngLiteralResp? = null,
        /**
         * The name of the transit stop.
         */
        @SerializedName("name")
        var name: String? = null
)
