package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [Geometry](https://developers.google.com/maps/documentation/places/web-service/search-nearby#Geometry)
 */
data class GeometryResp(
    @SerializedName("location")
    var location: LatLngLiteralResp? = null,
    @SerializedName("viewport")
    var viewport: BoundsResp? = null
)
