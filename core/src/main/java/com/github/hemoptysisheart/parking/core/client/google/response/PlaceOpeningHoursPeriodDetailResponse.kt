package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceOpeningHoursPeriodDetail](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlaceOpeningHoursPeriodDetail)
 */
data class PlaceOpeningHoursPeriodDetailResponse(
    @SerializedName("day")
    var day: Int? = null,
    @SerializedName("time")
    var time: String? = null,
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("truncated")
    var truncated: Boolean? = null
)
