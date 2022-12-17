package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceReview](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlaceReview)
 */
data class PlaceReviewResp(
    @SerializedName("author_name")
    var authorName: String? = null,
    @SerializedName("rating")
    var rating: Double? = null
)
