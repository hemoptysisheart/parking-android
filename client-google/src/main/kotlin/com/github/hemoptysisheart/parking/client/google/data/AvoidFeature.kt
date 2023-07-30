package com.github.hemoptysisheart.parking.client.google.data

enum class AvoidFeature(
    val code: String
) {
    /**
     * `tolls` indicates that the calculated route should avoid toll roads/bridges.
     */
    TOLLS("tolls"),

    /**
     * `highways` indicates that the calculated route should avoid highways.
     */
    HIGHWAYS("highways"),

    /**
     * `ferries` indicates that the calculated route should avoid ferries.
     */
    FERRIES("ferries"),

    /**
     * `indoor` indicates that the calculated route should avoid indoor steps for walking and transit directions.
     */
    INDOOR("indoor");

    companion object {
        private val CODE_MAP = values().associateBy { it.code }

        operator fun get(code: String) = CODE_MAP[code]!!

        operator fun get(ordinal: Int) = values()[ordinal]
    }
}
