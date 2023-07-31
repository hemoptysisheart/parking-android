package com.github.hemoptysisheart.parking.app.interaction.main

import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

class RouteNavigationInteraction(
    private val base: BaseInteraction
) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(RouteNavigationInteraction::class)
        const val ROUTE_PATTERN = "routeNavigation"

    }

    fun closeRouteNavigation() {
        LOGGER.i("#closeRouteNavigation called.")

        base.navController.navigate(LandingMapInteraction.ROUTE_PATTERN) {
            popUpTo(LandingMapInteraction.ROUTE_PATTERN) {
                inclusive = true
            }
        }
    }
}
