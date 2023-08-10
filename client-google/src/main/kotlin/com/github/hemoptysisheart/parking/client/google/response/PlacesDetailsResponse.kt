package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlacesDetailsResponse](https://developers.google.com/maps/documentation/places/web-service/details#PlacesDetailsResponse)
 */
data class PlacesDetailsResponse(
        /**
         * May contain a set of attributions about this listing which must be displayed to the user (some listings may not
         * have attribution).
         */
        @SerializedName("html_attributions")
        var htmlAttributions: List<String>? = null,
        /**
         * Contains the detailed information about the place requested.
         */
        @SerializedName("result")
        var result: PlaceResp? = null,
        /**
         * Contains the status of the request, and may contain debugging information to help you track down why the request
         * failed.
         */
        @SerializedName("status")
        var status: String? = null,
        /**
         * When the service returns additional information about the request specification, there may be an additional
         * `info_messages` field within the response object. This field is only returned for successful requests. It may
         * not always be returned, and its content is subject to change.
         */
        @SerializedName("info_messages")
        var infoMessages: List<String>? = null
)
