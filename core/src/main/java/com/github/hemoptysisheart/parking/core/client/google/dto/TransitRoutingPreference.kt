package com.github.hemoptysisheart.parking.core.client.google.dto

enum class TransitRoutingPreference(
    val code: String
) {
    /**
     * `less_walking` indicates that the calculated route should prefer limited amounts of walking.
     */
    LESS_WALKING("less_walking"),

    /**
     * `fewer_transfers` indicates that the calculated route should prefer a limited number of transfers.
     */
    FEWER_TRANSFERS("fewer_transfers");

    companion object {
        private val CODE_MAP = values().associateBy { it.code }

        operator fun get(code: String) = CODE_MAP[code]!!

        operator fun get(ordinal: Int) = values()[ordinal]
    }
}
