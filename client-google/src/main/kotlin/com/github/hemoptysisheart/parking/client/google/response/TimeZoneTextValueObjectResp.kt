package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [TimeZoneTextValueObject](https://developers.google.com/maps/documentation/directions/get-directions#TimeZoneTextValueObject)
 *
 * An object containing Unix time, a time zone, and its formatted text representation.
 */
data class TimeZoneTextValueObjectResp(
        /**
         * The time specified as a string in the time zone.
         */
        @SerializedName("text")
        var text: String? = null,
        /**
         * Contains the time zone. The value is the name of the time zone as defined in the [IANA Time Zone Database](http://www.iana.org/time-zones),
         * e.g. "America/New_York".
         */
        @SerializedName("time_zone")
        var timeZone: String? = null,
        /**
         * The time specified as Unix time, or seconds since midnight, January 1, 1970 UTC.
         */
        @SerializedName("value")
        var value: Double? = null
)
