package com.github.hemoptysisheart.parking.client.google.data

import java.time.Instant
import java.util.*

data class DirectionsParams(
    /**
     * The place ID, address, or textual latitude/longitude value from which you wish to calculate directions.
     */
    val origin: PlaceDescriptor,
    /**
     * The place ID, address, or textual latitude/longitude value to which you wish to calculate directions.
     * The options for the destination parameter are the same as for the origin parameter.
     */
    val destination: PlaceDescriptor,
    /**
     * If set to true, specifies that the Directions service may provide more than one route alternative in the
     * response. Note that providing route alternatives may increase the response time from the server. This is only
     * available for requests without intermediate waypoints. For more information, see the
     * [guide to waypoints](https://developers.google.com/maps/documentation/directions/get-directions#Waypoints).
     */
    val alternatives: Boolean? = null,
    /**
     * Specifies the desired time of arrival for transit directions, in seconds since midnight, January 1, 1970 UTC.
     * You can specify either `departure_time` or `arrival_time`, but not both. Note that arrival_time must be
     * specified as an integer.
     */
    val arrivalTime: Instant? = null,
    /**
     * Indicates that the calculated route(s) should avoid the indicated features.
     */
    val avoid: List<AvoidFeature>? = null,
    /**
     * Specifies the desired time of departure.
     */
    val departureTime: Instant? = null,
    /**
     * The language in which to return results.
     */
    val locale: Locale? = null,
    /**
     * For the calculation of distances and directions, you may specify the transportation mode to use.
     */
    val transportationMode: TransportationMode? = null,
    /**
     * The region code, specified as a [ccTLD ("top-level domain")](https://en.wikipedia.org/wiki/List_of_Internet_top-level_domains#Country_code_top-level_domains)
     * two-character value.
     */
    val region: String? = null,
    /**
     * Specifies the assumptions to use when calculating time in traffic.
     */
    val trafficModel: TrafficModel? = null,
    /**
     * Specifies one or more preferred modes of transit.
     */
    val transitMode: TransitMode? = null,
    /**
     * Specifies preferences for transit routes. Using this parameter, you can bias the options returned, rather than
     * accepting the default best route chosen by the API. This parameter may only be specified for transit directions.
     */
    val transitRoutingPreference: TransitRoutingPreference? = null,
    /**
     * Specifies the unit system to use when displaying results.
     *
     * Directions results contain text within distance fields that may be displayed to the user to indicate the
     * distance of a particular "step" of the route. By default, this text uses the unit system of the origin's country
     * or region.
     */
    val unit: DistanceUnit? = null,
    /**
     * Specifies an array of intermediate locations to include along the route between the `origin` and `destination`
     * points as pass through or stopover locations.
     */
    val waypoints: List<WaypointDescriptor>? = null
)
