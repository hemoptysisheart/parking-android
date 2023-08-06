package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceSpecialDay](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlaceSpecialDay)
 */
data class PlaceSpecialDayResp(
        @SerializedName("date")
        var date: String? = null,
        @SerializedName("exceptional_hours")
        var exceptionalHours: Boolean? = null
)
