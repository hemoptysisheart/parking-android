package com.github.hemoptysisheart.parking.app.interaction.main

import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

/**
 * [경로 선택](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-681)
 */
class SelectRouteInteraction(
        private val base: BaseInteraction
) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(SelectRouteInteraction::class)

        const val ROUTE_PATTERN = "main/selectRoute"
    }

    fun gotoRouteNavigation() {
        LOGGER.i("#gotoRouteNavigation called.")

        base.navController.navigate(RouteNavigationInteraction.ROUTE_PATTERN)
    }
}