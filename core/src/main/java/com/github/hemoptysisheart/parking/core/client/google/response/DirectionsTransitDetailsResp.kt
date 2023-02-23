package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [DirectionsTransitDetails](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitDetails)
 *
 * Additional information that is not relevant for other modes of transportation.
 */
data class DirectionsTransitDetailsResp(
    /**
     * The arrival transit stop.
     *
     * See [DirectionsTransitStop](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitStop)
     * for more information.
     */
    @SerializedName("arrival_stop")
    var arrivalStop: DirectionsTransitStopResp? = null,
    /**
     * See [TimeZoneTextValueObject](https://developers.google.com/maps/documentation/directions/get-directions#TimeZoneTextValueObject)
     * for more information.
     */
    @SerializedName("arrival_time")
    var arrivalTime: TimeZoneTextValueObjectResp? = null,
    /**
     * The departure transit stop.
     *
     * See [DirectionsTransitStop](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitStop)
     * for more information.
     */
    @SerializedName("departure_stop")
    var departureStop: DirectionsTransitStopResp? = null,
    /**
     * See [TimeZoneTextValueObject](https://developers.google.com/maps/documentation/directions/get-directions#TimeZoneTextValueObject)
     * for more information.
     */
    @SerializedName("departure_time")
    var departureTime: TimeZoneTextValueObjectResp? = null,
    /**
     * Specifies the direction in which to travel on this line, as it is marked on the vehicle or at the departure stop.
     * This will often be the terminus station.
     */
    @SerializedName("headsign")
    var headsign: String? = null,
    /**
     * Specifies the expected number of seconds between departures from the same stop at this time. For example, with a
     * headway value of 600, you would expect a ten minute wait if you should miss your bus.
     */
    @SerializedName("headway")
    var headway: Int? = null,
    /**
     * Contains information about the transit line used in this step.
     *
     * See [DirectionsTransitLine](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitLine)
     * for more information.
     */
    @SerializedName("line")
    var line: DirectionsTransitLineResp? = null,
    /**
     * The number of stops from the departure to the arrival stop. This includes the arrival stop, but not the
     * departure stop. For example, if your directions involve leaving from Stop A, passing through stops B and C, and
     * arriving at stop D, num_stops will return 3.
     */
    @SerializedName("num_stops")
    var numStops: Int? = null,
    /**
     * The text that appears in schedules and sign boards to identify a transit trip to passengers. The text should
     * uniquely identify a trip within a service day. For example, "538" is the trip_short_name of the Amtrak train
     * that leaves San Jose, CA at 15:10 on weekdays to Sacramento, CA.
     */
    @SerializedName("trip_short_name")
    var tripShortName: String? = null
)
