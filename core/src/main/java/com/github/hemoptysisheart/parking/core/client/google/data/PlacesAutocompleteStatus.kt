package com.github.hemoptysisheart.parking.core.client.google.data

/**
 * [PlacesAutocompleteStatus](https://developers.google.com/maps/documentation/places/web-service/autocomplete#PlacesAutocompleteStatus)
 */
enum class PlacesAutocompleteStatus {
    /**
     * indicating the API request was successful.
     */
    OK,

    /**
     * indicating that the search was successful but returned no results. This may occur if the search was passed a
     * bounds in a remote location.
     */
    ZERO_RESULTS,

    /**
     * indicating the API request was malformed, generally due to the missing input parameter.
     */
    INVALID_REQUEST,

    /**
     * indicating any of the following:
     *
     * - You have exceeded the QPS limits.
     * - Billing has not been enabled on your account.
     * - The monthly $200 credit, or a self-imposed usage cap, has been exceeded.
     * - The provided method of payment is no longer valid (for example, a credit card has expired).
     *
     * See the Maps FAQ for more information about how to resolve this error.
     */
    OVER_QUERY_LIMIT,

    /**
     * indicating that your request was denied, generally because:
     *
     * - The request is missing an API key.
     * - The key parameter is invalid.
     */
    REQUEST_DENIED,

    /**
     * indicating an unknown error.
     */
    UNKNOWN_ERROR;

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)
    }
}