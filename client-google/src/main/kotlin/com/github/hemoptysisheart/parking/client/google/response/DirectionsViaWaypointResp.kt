package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [DirectionsViaWaypoint](https://developers.google.com/maps/documentation/directions/get-directions?hl=ko#DirectionsViaWaypoint)
 */
data class DirectionsViaWaypointResp(
        /**
         * The location of the waypoint.
         *
         * See [LatLngLiteral](https://developers.google.com/maps/documentation/directions/get-directions#LatLngLiteral)
         * for more information.
         */
        @SerializedName("location")
        var location: LatLngLiteralResp? = null,
        /**
         * The index of the step containing the waypoint.
         */
        @SerializedName("step_index")
        var stepIndex: Int? = null,
        /**
         * The position of the waypoint along the step's polyline, expressed as a ratio from 0 to 1.
         */
        @SerializedName("step_interpolation")
        var stepInterpolation: Double? = null
)
