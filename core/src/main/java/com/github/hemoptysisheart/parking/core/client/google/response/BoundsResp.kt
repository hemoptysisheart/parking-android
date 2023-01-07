package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [Bounds](https://developers.google.com/maps/documentation/places/web-service/search-nearby#Bounds)
 */
data class BoundsResp(
    @SerializedName("northeast")
    var northEast: LatLngLiteralResp? = null,
    @SerializedName("southwest")
    var southWest: LatLngLiteralResp? = null
)
