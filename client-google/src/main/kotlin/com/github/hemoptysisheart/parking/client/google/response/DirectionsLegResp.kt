package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [DirectionsLeg](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsLeg)
 */
data class DirectionsLegResp(
        /**
         * Contains the human-readable address (typically a street address) from reverse geocoding the `end_location` of
         * this leg. This content is meant to be read as-is. Do not programmatically parse the formatted address.
         */
        @SerializedName("end_address")
        var endAddress: String? = null,
        /**
         * The latitude/longitude coordinates of the given destination of this leg. Because the Directions API calculates directions between locations by using the nearest transportation option (usually a road) at the start and end points, end_location may be different than the provided destination of this leg if, for example, a road is not near the destination.
         *
         * See [LatLngLiteral](https://developers.google.com/maps/documentation/directions/get-directions#LatLngLiteral)
         * for more information.
         */
        @SerializedName("end_location")
        var endLocation: LatLngLiteralResp? = null,
        /**
         * Contains the human-readable address (typically a street address) resulting from reverse geocoding the
         * `start_location` of this leg. This content is meant to be read as-is. Do not programmatically parse the
         * formatted address.
         */
        @SerializedName("start_address")
        var startAddress: String? = null,
        /**
         * The latitude/longitude coordinates of the origin of this leg. Because the Directions API calculates directions
         * between locations by using the nearest transportation option (usually a road) at the start and end points,
         * `start_location` may be different than the provided origin of this leg if, for example, a road is not near the
         * origin.
         *
         * See [LatLngLiteral](https://developers.google.com/maps/documentation/directions/get-directions#LatLngLiteral)
         * for more information.
         */
        @SerializedName("start_location")
        var startLocation: LatLngLiteralResp? = null,
        /**
         * An array of steps denoting information about each separate step of the leg of the journey.
         *
         * See [DirectionsStep](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsStep)
         * for more information.
         */
        @SerializedName("steps")
        var steps: List<DirectionsStepResp>? = null,
        /**
         * The locations of via waypoints along this leg.
         *
         * See [DirectionsViaWaypoint](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsViaWaypoint)
         * for more information.
         */
        @SerializedName("via_waypoint")
        var viaWaypoint: List<DirectionsViaWaypointResp>? = null,
        /**
         * Contains the estimated time of arrival for this leg. This property is only returned for transit directions.
         *
         * See [TimeZoneTextValueObject](https://developers.google.com/maps/documentation/directions/get-directions#TimeZoneTextValueObject)
         * for more information.
         */
        @SerializedName("arrival_time")
        var arrivalTime: TimeZoneTextValueObjectResp? = null,
        /**
         * Contains the estimated time of departure for this leg, specified as a Time object. The `departure_time` is only
         * available for transit directions.
         *
         * See [TimeZoneTextValueObject](https://developers.google.com/maps/documentation/directions/get-directions#TimeZoneTextValueObject)
         * for more information.
         */
        @SerializedName("departure_time")
        var departureTime: TimeZoneTextValueObjectResp? = null,
        /**
         * The total distance covered by this leg.
         *
         * See [TextValueObject](https://developers.google.com/maps/documentation/directions/get-directions#TextValueObject)
         * for more information.
         */
        @SerializedName("distance")
        var distance: TextValueObjectResp? = null,
        /**
         * The total duration of this leg.
         *
         * See [TextValueObject](https://developers.google.com/maps/documentation/directions/get-directions#TextValueObject)
         * for more information.
         */
        @SerializedName("duration")
        var duration: TextValueObjectResp? = null,
        /**
         * Indicates the total duration of this leg. This value is an estimate of the time in traffic based on current and
         * historical traffic conditions. See the `traffic_model` request parameter for the options you can use to request
         * that the returned value is optimistic, pessimistic, or a best-guess estimate. The duration in traffic is
         * returned only if all of the following are true:
         *
         * - The request does not include stopover waypoints. If the request includes waypoints, they must be prefixed with
         * via: to avoid stopovers.
         * - The request is specifically for driving directions—the mode parameter is set to driving.
         * - The request includes a departure_time parameter.
         * - Traffic conditions are available for the requested route.
         *
         * See [TextValueObject](https://developers.google.com/maps/documentation/directions/get-directions#TextValueObject)
         * for more information.
         */
        @SerializedName("duration_in_traffic")
        var durationInTraffic: TextValueObjectResp? = null,
)
