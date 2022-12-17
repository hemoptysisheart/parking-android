package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlacesNearbySearchResponse](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlacesNearbySearchResponse)
 */
data class NearbyResponse(
    @SerializedName("html_attributions")
    var htmlAttributions: List<String>? = null,
    @SerializedName("next_page_token")
    var nextPageToken: String? = null,
    @SerializedName("results")
    var results: List<PlaceResponse>? = null,
    @SerializedName("status")
    var status: String? = null
)
