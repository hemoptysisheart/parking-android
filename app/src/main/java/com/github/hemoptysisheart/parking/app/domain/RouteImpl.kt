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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RouteImpl

        if (origin != other.origin) return false
        if (parking != other.parking) return false
        if (destination != other.destination) return false
        if (driving != other.driving) return false
        if (walking != other.walking) return false

        return true
    }

    override fun hashCode(): Int {
        var result = origin.hashCode()
        result = 31 * result + parking.hashCode()
        result = 31 * result + destination.hashCode()
        result = 31 * result + driving.hashCode()
        result = 31 * result + walking.hashCode()
        return result
    }

    @Suppress("IMPLICIT_CAST_TO_ANY")
    override fun toString() = "RouteImpl(origin=$origin, parking=$parking, destination=$destination, " +
            "driving=${if (this::driving.isInitialized) driving else "[ not initialized ]"}, " +
            "walking=${if (this::walking.isInitialized) walking else "[ not initialized ]"})"
}
