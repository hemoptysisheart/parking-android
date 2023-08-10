package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [Bounds](https://developers.google.com/maps/documentation/places/web-service/search-nearby#Bounds)
 * [Bounds](https://developers.google.com/maps/documentation/directions/get-directions#Bounds)
 */
data class BoundsResp(
        /**
         * See [LatLngLiteral](https://developers.google.com/maps/documentation/directions/get-directions#LatLngLiteral)
         * for more information.
         */
        @SerializedName("northeast")
        var northEast: LatLngLiteralResp? = null,
        /**
         * See [LatLngLiteral](https://developers.google.com/maps/documentation/directions/get-directions#LatLngLiteral)
         * for more information.
         */
        @SerializedName("southwest")
        var southWest: LatLngLiteralResp? = null
)
