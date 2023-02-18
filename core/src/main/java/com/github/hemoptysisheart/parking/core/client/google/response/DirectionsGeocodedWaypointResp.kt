package com.github.hemoptysisheart.parking.core.client.google.response

import com.github.hemoptysisheart.parking.core.client.google.dto.GeocoderStatus
import com.google.gson.annotations.SerializedName

/**
 * [DirectionsGeocodedWaypoint](https://developers.google.com/maps/documentation/directions/get-directions?hl=ko#DirectionsGeocodedWaypoint)
 */
data class DirectionsGeocodedWaypointResp(
    /**
     * Indicates the status code resulting from the geocoding operation. This field may contain the following values.
     *
     * The allowed values include: OK, and ZERO_RESULTS
     */
    @SerializedName("geocoder_status")
    var geocoderStatus: GeocoderStatus? = null,
    /**
     * Indicates that the geocoder did not return an exact match for the original request, though it was able to match
     * part of the requested address. You may wish to examine the original request for misspellings and/or an
     * incomplete address.
     *
     * Partial matches most often occur for street addresses that do not exist within the locality you pass in the
     * request. Partial matches may also be returned when a request matches two or more locations in the same locality.
     * For example, "21 Henr St, Bristol, UK" will return a partial match for both Henry Street and Henrietta Street.
     * Note that if a request includes a misspelled address component, the geocoding service may suggest an alternative
     * address. Suggestions triggered in this way will also be marked as a partial match.
     */
    @SerializedName("partial_match")
    var partialMatch: Boolean? = null,
    /**
     * A unique identifier that can be used with other Google APIs.
     * See the [Place ID overview](https://developers.google.com/maps/documentation/places/web-service/place-id).
     */
    @SerializedName("place_id")
    var placeId: String? = null,
    /**
     * Indicates the address type of the geocoding result used for calculating directions.
     */
    @SerializedName("types")
    var types: List<String>? = null
)
