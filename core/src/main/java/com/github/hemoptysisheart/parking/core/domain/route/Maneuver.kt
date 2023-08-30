package com.github.hemoptysisheart.parking.core.domain.route

import com.github.hemoptysisheart.parking.domain.route.Maneuver

val com.github.hemoptysisheart.parking.client.google.data.Maneuver.domain
    get() = when (this) {
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.TURN_SLIGHT_LEFT -> Maneuver.TURN_SLIGHT_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.TURN_SHARP_LEFT -> Maneuver.TURN_SHARP_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.TURN_LEFT -> Maneuver.TURN_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.TURN_SLIGHT_RIGHT -> Maneuver.TURN_SLIGHT_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.TURN_SHARP_RIGHT -> Maneuver.TURN_SHARP_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.KEEP_RIGHT -> Maneuver.KEEP_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.KEEP_LEFT -> Maneuver.KEEP_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.UTURN_LEFT -> Maneuver.UTURN_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.UTURN_RIGHT -> Maneuver.UTURN_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.TURN_RIGHT -> Maneuver.TURN_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.STRAIGHT -> Maneuver.STRAIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.RAMP_LEFT -> Maneuver.RAMP_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.RAMP_RIGHT -> Maneuver.RAMP_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.MERGE -> Maneuver.MERGE
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.FORK_LEFT -> Maneuver.FORK_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.FORK_RIGHT -> Maneuver.FORK_RIGHT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.FERRY -> Maneuver.FERRY
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.FERRY_TRAIN -> Maneuver.FERRY_TRAIN
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.ROUNDABOUT_LEFT -> Maneuver.ROUNDABOUT_LEFT
        com.github.hemoptysisheart.parking.client.google.data.Maneuver.ROUNDABOUT_RIGHT -> Maneuver.ROUNDABOUT_RIGHT
    }
