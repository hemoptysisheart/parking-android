package com.github.hemoptysisheart.parking.client.google.response

/**
 * [PlacesSearchStatus](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlacesSearchStatus)
 */
enum class PlacesSearchStatus {
    OK,
    ZERO_RESULTS,
    INVALID_REQUEST,
    OVER_QUERY_LIMIT,
    REQUEST_DENIED,
    UNKNOWN_ERROR;

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]
    }
}