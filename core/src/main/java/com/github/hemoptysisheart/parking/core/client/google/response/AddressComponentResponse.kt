package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [AddressComponent](https://developers.google.com/maps/documentation/places/web-service/search-nearby#AddressComponent)
 */
data class AddressComponentResponse(
    @SerializedName("long_name")
    var longName: String? = null,
    @SerializedName("short_name")
    var shortName: String? = null,
    @SerializedName("types")
    var types: List<String>? = null
)
