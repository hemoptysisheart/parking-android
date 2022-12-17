package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [Bounds](https://developers.google.com/maps/documentation/places/web-service/search-nearby#Bounds)
 */
data class BoundsResponse(
    @SerializedName("northeast")
    var northEast: LatLngLiteralResponse? = null,
    @SerializedName("southwest")
    var southWest: LatLngLiteralResponse? = null
)
