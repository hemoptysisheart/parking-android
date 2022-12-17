package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceReview](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlaceReview)
 */
data class PlaceReviewResp(
    @SerializedName("author_name")
    var authorName: String? = null,
    @SerializedName("rating")
    var rating: Double? = null,
    @SerializedName("relative_time_description")
    var relativeTimeDescription: String? = null,
    @SerializedName("time")
    var time: Long? = null,
    @SerializedName("author_url")
    var authorUrl: String? = null,
    @SerializedName("language")
    var language: String? = null,
    @SerializedName("original_language")
    var originalLanguage: String? = null,
    @SerializedName("profile_photo_url")
    var profilePhotoUrl: String? = null,
    @SerializedName("text")
    var text: String? = null,
    @SerializedName("translated")
    var translated: Boolean? = null
)
