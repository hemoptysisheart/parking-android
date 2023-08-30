package com.github.hemoptysisheart.parking.core.domain.route

import com.github.hemoptysisheart.parking.domain.route.Maneuver

enum class Maneuvers : Maneuver {
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

        operator fun get(name: String) = valueOf(name)
    }
}

val com.github.hemoptysisheart.parking.client.google.data.Maneuver.domain
    get() = when (this) {
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.TURN_SLIGHT_LEFT -> Maneuvers.TURN_SLIGHT_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.TURN_SHARP_LEFT -> Maneuvers.TURN_SHARP_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.TURN_LEFT -> Maneuvers.TURN_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.TURN_SLIGHT_RIGHT -> Maneuvers.TURN_SLIGHT_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.TURN_SHARP_RIGHT -> Maneuvers.TURN_SHARP_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.KEEP_RIGHT -> Maneuvers.KEEP_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.KEEP_LEFT -> Maneuvers.KEEP_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.UTURN_LEFT -> Maneuvers.UTURN_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.UTURN_RIGHT -> Maneuvers.UTURN_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.TURN_RIGHT -> Maneuvers.TURN_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.STRAIGHT -> Maneuvers.STRAIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.RAMP_LEFT -> Maneuvers.RAMP_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.RAMP_RIGHT -> Maneuvers.RAMP_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.MERGE -> Maneuvers.MERGE
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.FORK_LEFT -> Maneuvers.FORK_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.FORK_RIGHT -> Maneuvers.FORK_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.FERRY -> Maneuvers.FERRY
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.FERRY_TRAIN -> Maneuvers.FERRY_TRAIN
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.ROUNDABOUT_LEFT -> Maneuvers.ROUNDABOUT_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.ROUNDABOUT_RIGHT -> Maneuvers.ROUNDABOUT_RIGHT
    }