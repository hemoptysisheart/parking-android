package com.github.hemoptysisheart.parking.client.google.data

enum class PlacesDetailsStatus {
    /**
     * indicating the API request was successful.
     */
    OK,

    /**
     * indicating that the referenced location, place_id, was valid but no longer refers to a valid result. This may
     * occur if the establishment is no longer in business.
     */
    ZERO_RESULTS,

    /**
     * indicating that that the referenced location, place_id, was not found in the Places database.
     */
    NOT_FOUND,

    /**
     * indicating the API request was malformed.
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
     * See the [Maps FAQ](https://developers.google.com/maps/faq#over-limit-key-error) for more information about how
     * to resolve this error.
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
