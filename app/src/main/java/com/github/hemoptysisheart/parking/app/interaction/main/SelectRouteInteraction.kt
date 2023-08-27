package com.github.hemoptysisheart.parking.app.interaction.main

import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.app.interaction.InteractionMeta
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.place.Place

/**
 * [경로 선택](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-681)
 */
class SelectRouteInteraction(
        private val base: BaseInteraction
) : Interaction by base {
    companion object : InteractionMeta {
        private const val ROUTE_PREFIX = "main/selectRoute"
        private val LOGGER = AndroidLogger(SelectRouteInteraction::class)

        const val ARG_DESTINATION = "destination"
        const val ARG_PARKING = "parking"

        const val ROUTE_PATTERN = "$ROUTE_PREFIX/{${ARG_PARKING}}/{${ARG_DESTINATION}}"

        fun route(parking: Place, destination: Place): String {
            val route = "$ROUTE_PREFIX/${arg(parking)}/${arg(destination)}"
            LOGGER.d("#route : parking=$parking, destination=$destination => $route")
            return route
        }
    }

    fun gotoRouteNavigation() {
        LOGGER.i("#gotoRouteNavigation called.")

        base.navController.navigate(RouteNavigationInteraction.ROUTE_PATTERN)
    }
}