package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [DirectionsResponse](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsResponse)
 */
data class DirectionsResponse(
    /**
     * Contains an array of routes from the origin to the destination. Routes consist of nested Legs and Steps.
     *
     * See [DirectionsRoute](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsRoute)
     * for more information.
     */
    @SerializedName("routes")
    var routes: List<DirectionsRouteResp>? = null,
    /**
     * Contains the status of the request, and may contain debugging information to help you track down why the request failed.
     *
     * See [DirectionsStatus](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsStatus)
     * for more information.
     */
    @SerializedName("status")
    var status: String? = null,
    /**
     * Contains an array of available travel modes. This field is returned when a request specifies a travel mode and
     * gets no results. The array contains the available travel modes in the countries of the given set of waypoints.
     * This field is not returned if one or more of the waypoints are 'via waypoints'.
     *
     * See [TravelMode](https://developers.google.com/maps/documentation/directions/get-directions?hl=ko#TravelMode)
     * for more information.
     */
    @SerializedName("available_travel_modes")
    var availableTravelModes: List<String>? = null,
    /**
     * When the service returns a status code other than OK, there may be an additional `error_message` field within
     * the response object. This field contains more detailed information about the reasons behind the given status code.
     * This field is not always returned, and its content is subject to change.
     */
    @SerializedName("error_message")
    var errorMessage: String? = null,
    /**
     * Contains an array with details about the geocoding of origin, destination and waypoints. Elements in the
     * `geocoded_waypoints` array correspond, by their zero-based position, to the origin, the waypoints in the order
     * they are specified, and the destination.
     *
     * These details will not be present for waypoints specified as textual latitude/longitude values if the service
     * returns no results. This is because such waypoints are only reverse geocoded to obtain their representative
     * address after a route has been found. An empty JSON object will occupy the corresponding places in the
     * `geocoded_waypoints` array.
     *
     * See [DirectionsGeocodedWaypoint](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsGeocodedWaypoint)
     * for more information.
     */
    @SerializedName("geocoded_waypoints")
    var geocodedWaypoints: List<DirectionsGeocodedWaypointResp>? = null
)
