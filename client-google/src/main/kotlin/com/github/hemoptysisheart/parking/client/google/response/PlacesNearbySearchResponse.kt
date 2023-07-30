package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlacesNearbySearchResponse](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlacesNearbySearchResponse)
 */
data class PlacesNearbySearchResponse(
    @SerializedName("html_attributions")
    var htmlAttributions: List<String>? = null,
    @SerializedName("results")
    var results: List<PlaceResp>? = null,
    @SerializedName("status")
    var status: PlacesSearchStatus? = null,
    @SerializedName("error_message")
    var errorMessage: String? = null,
    @SerializedName("info_messages")
    var infoMessages: List<String>? = null,
    @SerializedName("next_page_token")
    var nextPageToken: String? = null
)
