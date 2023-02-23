package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlacePhoto](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlacePhoto)
 */
data class PlacePhotoResp(
    @SerializedName("height")
    var height: Int? = null,
    @SerializedName("html_attributions")
    var htmlAttributions: List<String>? = null,
    @SerializedName("photo_reference")
    var photoReference: String? = null,
    @SerializedName("width")
    var width: Int? = null
)
