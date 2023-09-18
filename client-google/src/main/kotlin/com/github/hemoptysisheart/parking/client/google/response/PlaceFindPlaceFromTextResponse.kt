package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlacesFindPlaceFromTextResponse](https://developers.google.com/maps/documentation/places/web-service/search-find-place#PlacesFindPlaceFromTextResponse)
 */
data class PlaceFindPlaceFromTextResponse(
        /**
         * `candidates`
         *
         * Contains an array of Place candidates.
         */
        @SerializedName("candidates")
        var candidates: List<PlaceResp>? = null,
        /**
         * `status`
         *
         * Contains the status of the request, and may contain debugging information to help you track down why the
         * request failed.
         *
         * See
         * [PlacesSearchStatus](https://developers.google.com/maps/documentation/places/web-service/search-find-place#PlacesSearchStatus)
         * for more information.
         */
        @SerializedName("status")
        var status: PlacesSearchStatus? = null,
        /**
         * `error_message`
         *
         * When the service returns a status code other than OK<, there may be an additional error_message field within
         * the response object. This field contains more detailed information about thereasons behind the given status
         * code. This field is not always returned, and its content is subject to change.
         */
        @SerializedName("error_message")
        var errorMessage: String? = null,
        /**
         * `info_messages`
         *
         * When the service returns additional information about the request specification, there may be an additional
         * info_messages field within the response object. This field is only returned for successful requests. It may
         * not always be returned, and its content is subject to change.
         */
        @SerializedName("info_messages")
        var info_messages: List<String>? = null,
)
