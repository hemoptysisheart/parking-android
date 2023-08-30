package com.github.hemoptysisheart.parking.app.interaction.main

import androidx.lifecycle.SavedStateHandle
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.app.interaction.InteractionMeta
import com.github.hemoptysisheart.parking.core.domain.common.toIdentifier
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.route.Route

/**
 * [경로 선택](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-681)
 */
class SelectRouteInteraction(
        private val base: BaseInteraction
) : Interaction by base {
    data class Args(
            val parking: Identifier,
            val destination: Identifier
    )

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

        fun args(savedStateHandle: SavedStateHandle): Args {
            val parking: String = savedStateHandle[ARG_PARKING]
                    ?: throw IllegalArgumentException("$ARG_PARKING is null.")
            val destination: String = savedStateHandle[ARG_DESTINATION]
                    ?: throw IllegalArgumentException("$ARG_DESTINATION is null.")

            return Args(parking.toIdentifier(), destination.toIdentifier())
        }
    }

    fun gotoRouteNavigation(route: Route) {
        val r = RouteNavigationInteraction.route(route.drive, route.walk)
        LOGGER.d("#gotoRouteNavigation route=${route.id} => $r")
        base.navController.navigate(r)
    }
}