package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlacesAutocompleteResponse](https://developers.google.com/maps/documentation/places/web-service/autocomplete#PlacesAutocompleteResponse)
 */
data class PlacesAutocompleteResponse(
        /**
         * Contains an array of predictions.
         */
        @SerializedName("predictions")
        var predictions: List<PlaceAutocompletePredictionResp>? = null,
        /**
         * Contains the status of the request, and may contain debugging information to help you track down why the request
         * failed.
         */
        @SerializedName("status")
        var status: String? = null,
        /**
         * When the service returns a status code other than OK<, there may be an additional error_message field within the
         * response object. This field contains more detailed information about thereasons behind the given status code.
         * This field is not always returned, and its content is subject to change.
         */
        @SerializedName("error_message")
        var errorMessage: String? = null,
        /**
         * When the service returns additional information about the request specification, there may be an additional
         * `info_messages` field within the response object. This field is only returned for successful requests. It may
         * not always be returned, and its content is subject to change.
         */
        @SerializedName("info_messages")
        var infoMessages: List<String>? = null
)
