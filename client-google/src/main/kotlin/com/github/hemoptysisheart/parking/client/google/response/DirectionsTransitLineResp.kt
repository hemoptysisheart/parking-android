package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [DirectionsTransitLine](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitLine)
 */
data class DirectionsTransitLineResp(
        /**
         * The transit agency (or agencies) that operates this transit line.
         *
         * See [DirectionsTransitAgency](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitAgency)
         * for more information.
         */
        @SerializedName("agencies")
        var agencies: List<DirectionsTransitAgencyResp>? = null,
        /**
         * The full name of this transit line, e.g. "8 Avenue Local".
         */
        @SerializedName("name")
        var name: String? = null,
        /**
         * The color commonly used in signage for this line.
         */
        @SerializedName("color")
        var color: String? = null,
        /**
         * Contains the URL for the icon associated with this line.
         */
        @SerializedName("icon")
        var icon: String? = null,
        /**
         * The short name of this transit line. This will normally be a line number, such as "M7" or "355".
         */
        @SerializedName("short_name")
        var shortName: String? = null,
        /**
         * The color commonly used in signage for this line.
         */
        @SerializedName("text_color")
        var textColor: String? = null,
        /**
         * Contains the URL for this transit line as provided by the transit agency.
         */
        @SerializedName("url")
        var url: String? = null,
        /**
         *The type of vehicle that operates on this transit line.
         *
         * See [DirectionsTransitVehicle](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitVehicle)
         * for more information.
         */
        @SerializedName("vehicle")
        var vehicle: DirectionsTransitVehicleResp? = null
)
