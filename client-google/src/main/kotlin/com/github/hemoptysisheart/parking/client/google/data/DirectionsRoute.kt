package com.github.hemoptysisheart.parking.client.google.data

/**
 * [DirectionsRoute](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsRoute)
 */
data class DirectionsRoute(
    /**
     * Contains the viewport bounding box of the overview_polyline.
     *
     * See [Bounds](https://developers.google.com/maps/documentation/directions/get-directions#Bounds) for more information.
     */
    val bounds: Bounds,
    /**
     * Contains the copyright notices to be displayed for this route. You must handle and display this information
     * yourself. This content is meant to be read as-is. Do not programmatically parse this display-only content.
     */
    val copyrights: String,
    /**
     * An array which contains information about a leg of the route, between two locations within the given route.
     * A separate leg will be present for each waypoint or destination specified. (A route with no waypoints will
     * contain exactly one leg within the legs array.) Each leg consists of a series of steps.
     *
     * See [DirectionsLeg](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsLeg)
     * for more information.
     */
    val legs: List<DirectionsLeg>,
    /**
     * Contains an object that holds an encoded polyline representation of the route. This polyline is an approximate
     * (smoothed) path of the resulting directions.
     *
     * See [DirectionsPolyline](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsPolyline)
     * for more information.
     */
    val overviewPolyline: DirectionsPolyline,
    /**
     * Contains a short textual description for the route, suitable for naming and disambiguating the route from
     * alternatives.
     */
    val summary: String,
    /**
     * Contains an array of warnings to be displayed when showing these directions. You must handle and display these
     * warnings yourself.
     */
    val warnings: List<String>,
    /**
     * An array indicating the order of any waypoints in the calculated route. This waypoints may be reordered if
     * the request was passed optimize:true within its waypoints parameter.
     */
    val waypointOrder: List<Int>,
    /**
     * If present, contains the total fare (that is, the total ticket costs) on this route. This property is only
     * returned for transit requests and only for routes where fare information is available for all transit legs.
     *
     * See [Fare](https://developers.google.com/maps/documentation/directions/get-directions#Fare) for more information.
     */
    val fare: Fare? = null
)
