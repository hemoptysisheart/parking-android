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

    @Suppress("IMPLICIT_CAST_TO_ANY")
    override fun toString() = "RouteImpl(origin=$origin, parking=$parking, destination=$destination, " +
            "driving=${if (this::driving.isInitialized) driving else "[ not initialized ]"}, " +
            "walking=${if (this::walking.isInitialized) walking else "[ not initialized ]"})"
}
