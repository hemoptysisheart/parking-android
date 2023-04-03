package com.github.hemoptysisheart.parking.domain

enum class Maneuver {
    TURN_SLIGHT_LEFT,
    TURN_SHARP_LEFT,
    TURN_LEFT,
    TURN_SLIGHT_RIGHT,
    TURN_SHARP_RIGHT,
    KEEP_RIGHT,
    KEEP_LEFT,
    UTURN_LEFT,
    UTURN_RIGHT,
    TURN_RIGHT,
    STRAIGHT,
    RAMP_LEFT,
    RAMP_RIGHT,
    MERGE,
    FORK_LEFT,
    FORK_RIGHT,
    FERRY,
    FERRY_TRAIN,
    ROUNDABOUT_LEFT,
    ROUNDABOUT_RIGHT;

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]
    }
}
