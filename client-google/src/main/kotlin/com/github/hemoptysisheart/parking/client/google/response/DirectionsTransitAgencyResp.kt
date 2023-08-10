package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [DirectionsTransitAgency](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitAgency)
 */
data class DirectionsTransitAgencyResp(
        /**
         * The name of this transit agency.
         */
        @SerializedName("name")
        var name: String? = null,
        /**
         * The transit agency's phone number.
         */
        @SerializedName("phone")
        var phone: String? = null,
        /**
         * The transit agency's URL.
         */
        @SerializedName("url")
        var url: String? = null
)
