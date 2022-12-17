package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceOpeningHours](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlaceOpeningHours)
 */
data class PlaceOpeningHoursResponse(
    @SerializedName("open_now")
    var open: Boolean? = null,
    @SerializedName("periods")
    var periods: List<PlaceOpeningHoursPeriodResponse>? = null,
    @SerializedName("special_days")
    var specialDays: List<PlaceSpecialDayResponse>? = null,
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("weekday_text")
    var weekdayText: String? = null
)
