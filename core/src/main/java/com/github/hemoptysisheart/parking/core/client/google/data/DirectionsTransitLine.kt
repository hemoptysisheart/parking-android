package com.github.hemoptysisheart.parking.core.client.google.data

import android.net.Uri

/**
 * [DirectionsTransitLine](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitLine)
 */
data class DirectionsTransitLine(
    /**
     * The transit agency (or agencies) that operates this transit line.
     *
     * See [DirectionsTransitAgency](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitAgency)
     * for more information.
     */
    val agencies: List<DirectionsTransitAgency>,
    /**
     * The full name of this transit line, e.g. "8 Avenue Local".
     */
    val name: String,
    /**
     * The color commonly used in signage for this line.
     */
    val color: String? = null,
    /**
     * Contains the URL for the icon associated with this line.
     */
    val icon: Uri? = null,
    /**
     * The short name of this transit line. This will normally be a line number, such as "M7" or "355".
     */
    val shortName: String? = null,
    /**
     * The color commonly used in signage for this line.
     */
    val textColor: String? = null,
    /**
     * Contains the URL for this transit line as provided by the transit agency.
     */
    val url: Uri? = null,
    /**
     *The type of vehicle that operates on this transit line.
     *
     * See [DirectionsTransitVehicle](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitVehicle)
     * for more information.
     */
    val vehicle: DirectionsTransitVehicle? = null
)
