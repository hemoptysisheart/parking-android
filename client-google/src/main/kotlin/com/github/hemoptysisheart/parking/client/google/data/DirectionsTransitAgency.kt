package com.github.hemoptysisheart.parking.client.google.data

import java.net.URL

/**
 * [DirectionsTransitAgency](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitAgency)
 */
data class DirectionsTransitAgency(
        /**
         * The name of this transit agency.
         */
        val name: String?,
        /**
         * The transit agency's phone number.
         */
        val phone: String?,
        /**
         * The transit agency's URL.
         */
        val url: URL?
)
