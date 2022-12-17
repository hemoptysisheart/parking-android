package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceOpeningHoursPeriod](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlaceOpeningHoursPeriod)
 */
data class PlaceOpeningHoursPeriodResponse(
    @SerializedName("open")
    var open: PlaceOpeningHoursPeriodDetailResponse? = null,
    @SerializedName("close")
    var close: PlaceOpeningHoursPeriodDetailResponse? = null
)
