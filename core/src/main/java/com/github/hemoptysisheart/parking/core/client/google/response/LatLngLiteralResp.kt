package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [LatLngLiteral](https://developers.google.com/maps/documentation/places/web-service/search-nearby#LatLngLiteral)
 */
data class LatLngLiteralResp(
    @SerializedName("lat")
    var lat: Double? = null,
    @SerializedName("lng")
    var lng: Double? = null
)
