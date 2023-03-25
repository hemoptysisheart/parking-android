package com.github.hemoptysisheart.parking.app.domain

import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.PartialRoute
import com.github.hemoptysisheart.parking.domain.Route

data class RouteImpl(
    override val origin: Location,
    override val parking: Location,
    override val destination: Location
) : Route {
    var initialized = false
        get() = this::driving.isInitialized && this::walking.isInitialized
        private set

    override lateinit var driving: PartialRoute

    override lateinit var walking: PartialRoute
    override fun equals(other: Any?) = this === other ||
            javaClass == other?.javaClass &&
            other is RouteImpl &&
            origin == other.origin &&
            parking == other.parking &&
            destination == other.destination &&
            initialized &&
            other.initialized &&
            driving == other.driving &&
            walking == other.walking

    override fun hashCode(): Int {
        var result = origin.hashCode()
        result = 31 * result + parking.hashCode()
        result = 31 * result + destination.hashCode()
        if (initialized) {
            result = 31 * result + driving.hashCode()
            result = 31 * result + walking.hashCode()
        }
        return result
    }

    override fun toString() = if (initialized) {
        "RouteImpl(origin=$origin, parking=$parking, destination=$destination, driving=$driving, walking=$walking)"
    } else {
        "RouteImpl(origin=$origin, parking=$parking, destination=$destination, driving=[ NOT INITIALIZED ], walking=[ NOT INITIALIZED ])"
    }
}
