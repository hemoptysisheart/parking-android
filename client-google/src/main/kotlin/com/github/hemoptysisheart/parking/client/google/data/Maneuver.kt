package com.github.hemoptysisheart.parking.client.google.data

enum class Maneuver(
        val code: String
) {
    TURN_SLIGHT_LEFT("turn-slight-left"),
    TURN_SHARP_LEFT("turn-sharp-left"),
    TURN_LEFT("turn-left"),
    TURN_SLIGHT_RIGHT("turn-slight-right"),
    TURN_SHARP_RIGHT("turn-sharp-right"),
    KEEP_RIGHT("keep-right"),
    KEEP_LEFT("keep-left"),
    UTURN_LEFT("uturn-left"),
    UTURN_RIGHT("uturn-right"),
    TURN_RIGHT("turn-right"),
    STRAIGHT("straight"),
    RAMP_LEFT("ramp-left"),
    RAMP_RIGHT("ramp-right"),
    MERGE("merge"),
    FORK_LEFT("fork-left"),
    FORK_RIGHT("fork-right"),
    FERRY("ferry"),
    FERRY_TRAIN("ferry-train"),
    ROUNDABOUT_LEFT("roundabout-left"),
    ROUNDABOUT_RIGHT("roundabout-right");

    companion object {
        private val CODE_MAP = values().associateBy { it.code }

        /**
         * @param code See [Maneuver.code].
         */
        operator fun get(code: String) = CODE_MAP[code]!!

        operator fun get(ordinal: Int) = values()[ordinal]
    }
}
