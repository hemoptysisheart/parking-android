package com.github.hemoptysisheart.parking.core.client.google.dto

/**
 * See [`traffic_model`](https://developers.google.com/maps/documentation/directions/get-directions#traffic_model)
 */
enum class TrafficModel(
    val code: String
) {
    /**
     * `best_guess` (default) indicates that the returned duration_in_traffic should be the best estimate of travel
     * time given what is known about both historical traffic conditions and live traffic. Live traffic becomes more
     * important the closer the `departure_time` is to now.
     */
    BEST_GUESS("best_guess"),

    /**
     * `pessimistic` indicates that the returned duration_in_traffic should be longer than the actual travel time on
     * most days, though occasional days with particularly bad traffic conditions may exceed this value.
     */
    PESSIMISTIC("pessimistic"),

    /**
     * `optimistic` indicates that the returned duration_in_traffic should be shorter than the actual travel time on
     * most days, though occasional days with particularly good traffic conditions may be faster than this value.
     */
    OPTIMISTIC("optimistic");

    companion object {
        private val CODE_MAP = values().associateBy { it.code }

        operator fun get(code: String) = CODE_MAP[code]!!

        operator fun get(ordinal: Int) = values()[ordinal]
    }
}