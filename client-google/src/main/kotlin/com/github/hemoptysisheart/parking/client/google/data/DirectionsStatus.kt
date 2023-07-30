package com.github.hemoptysisheart.parking.client.google.data

/**
 * [DirectionsStatus](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsStatus)
 *
 * The status field within the Directions response object contains the status of the request, and may contain debugging
 * information to help you track down why the Directions service failed.
 */
enum class DirectionsStatus {
    /**
     * indicates the response contains a valid result.
     */
    OK,

    /**
     * indicates at least one of the locations specified in the request's origin, destination, or waypoints could not be geocoded.
     */
    NOT_FOUND,

    /**
     * indicates no route could be found between the origin and destination.
     */
    ZERO_RESULTS,

    /**
     *  indicates that too many waypoints were provided in the request. For applications using the Directions API as a web service, or the directions service in the Maps JavaScript API, the maximum allowed number of waypoints is 25, plus the origin and destination.
     */
    MAX_WAYPOINTS_EXCEEDED,

    /**
     * indicates the requested route is too long and cannot be processed. This error occurs when more complex directions are returned. Try reducing the number of waypoints, turns, or instructions.
     **/
    MAX_ROUTE_LENGTH_EXCEEDED,

    /**
     * indicates that the provided request was invalid. Common causes of this status include an invalid parameter or parameter value.
     **/
    INVALID_REQUEST,

    /**
     * indicates any of the following:
     * - The API key is missing or invalid.
     * - Billing has not been enabled on your account.
     * - A self-imposed usage cap has been exceeded.
     * - The provided method of payment is no longer valid (for example, a credit card has expired).
     *
     * See the [Maps FAQ](https://developers.google.com/maps/faq#over-limit-key-error) to learn how to fix this.
     **/
    OVER_DAILY_LIMIT,

    /**
     * indicates the service has received too many requests from your application within the allowed time period.
     **/
    OVER_QUERY_LIMIT,

    /**
     * indicates that the service denied use of the directions service by your application.
     **/
    REQUEST_DENIED,

    /**
     * indicates a directions request could not be processed due to a server error. The request may succeed if you try
     * again.
     **/
    UNKNOWN_ERROR;

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]
    }
}