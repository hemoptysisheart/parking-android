package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceEditorialSummary](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlaceEditorialSummary)
 */
data class PlaceEditorialSummaryResp(
    @SerializedName("language")
    var language: String? = null,
    @SerializedName("overview")
    var overview: String? = null
)
