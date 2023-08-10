package com.github.hemoptysisheart.parking.client.google.data

/**
 * See [`transit_mode`](https://developers.google.com/maps/documentation/directions/get-directions?hl=ko#transit_mode)
 */
enum class TransitMode(
        val code: String
) {
    /**
     * `bus` indicates that the calculated route should prefer travel by bus.
     */
    BUS("bus"),

    /**
     * `subway` indicates that the calculated route should prefer travel by subway.
     */
    SUBWAY("subway"),

    /**
     * `train` indicates that the calculated route should prefer travel by train.
     */
    TRAIN("train"),

    /**
     * `tram` indicates that the calculated route should prefer travel by tram and light rail.
     */
    TRAM("tram"),

    /**
     * `rail` indicates that the calculated route should prefer travel by train, tram, light rail, and subway.
     * This is equivalent to `transit_mode=train|tram|subway`.
     */
    RAIL("rail");

    companion object {
        private val CODE_MAP = values().associateBy { it.code }

        operator fun get(code: String) = CODE_MAP[code]!!

        operator fun get(ordinal: Int) = values()[ordinal]
    }
}
