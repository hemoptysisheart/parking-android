package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceOpeningHours](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlaceOpeningHours)
 */
data class PlaceOpeningHoursResp(
        @SerializedName("open_now")
        var open: Boolean? = null,
        @SerializedName("periods")
        var periods: List<PlaceOpeningHoursPeriodResp>? = null,
        @SerializedName("special_days")
        var specialDays: List<PlaceSpecialDayResp>? = null,
        @SerializedName("type")
        var type: String? = null,
        @SerializedName("weekday_text")
        var weekdayText: List<String>? = null
)
