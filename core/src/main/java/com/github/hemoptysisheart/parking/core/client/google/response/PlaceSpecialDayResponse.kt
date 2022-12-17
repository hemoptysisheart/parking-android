package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceSpecialDay](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlaceSpecialDay)
 */
data class PlaceSpecialDayResponse(
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("exceptional_hours")
    var exceptionalHours: Boolean? = null
)
