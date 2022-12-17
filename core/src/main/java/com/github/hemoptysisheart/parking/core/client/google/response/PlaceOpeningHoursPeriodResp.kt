package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceOpeningHoursPeriod](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlaceOpeningHoursPeriod)
 */
data class PlaceOpeningHoursPeriodResp(
    @SerializedName("open")
    var open: PlaceOpeningHoursPeriodDetailResp? = null,
    @SerializedName("close")
    var close: PlaceOpeningHoursPeriodDetailResp? = null
)
