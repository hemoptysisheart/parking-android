package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [Geometry](https://developers.google.com/maps/documentation/places/web-service/search-nearby#Geometry)
 */
data class GeometryResponse(
    @SerializedName("location")
    var location: LatLngLiteralResponse? = null,
    @SerializedName("viewport")
    var viewport: BoundsResponse? = null
)
