package com.github.hemoptysisheart.parking.client.google.data

/**
 * [DirectionsViaWaypoint](https://developers.google.com/maps/documentation/directions/get-directions?hl=ko#DirectionsViaWaypoint)
 */
data class DirectionsViaWaypoint(
        /**
         * The location of the waypoint.
         *
         * See [LatLngLiteral](https://developers.google.com/maps/documentation/directions/get-directions#LatLngLiteral)
         * for more information.
         */
        val location: LatLng?,
        /**
         * The index of the step containing the waypoint.
         */
        val stepIndex: Int?,
        /**
         * The position of the waypoint along the step's polyline, expressed as a ratio from 0 to 1.
         */
        val stepInterpolation: Double?
)
