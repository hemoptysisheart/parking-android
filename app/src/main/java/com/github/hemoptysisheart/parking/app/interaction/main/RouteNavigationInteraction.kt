package com.github.hemoptysisheart.parking.app.interaction.main

import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.route.SubRoute
import java.net.URLEncoder.encode
import java.nio.charset.StandardCharsets.UTF_8

/**
 * [경로 안내](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-693)
 */
class RouteNavigationInteraction(
        private val base: BaseInteraction
) : Interaction by base {
    companion object {
        private const val ROUTE_PREFIX = "main/routeNavigation"
        private val LOGGER = AndroidLogger(RouteNavigationInteraction::class)

        const val ARG_DRIVE = "drive"
        const val ARG_WALK = "walk"

        const val ROUTE_PATTERN = "$ROUTE_PREFIX/{$ARG_DRIVE}/{$ARG_WALK}"

        fun route(drive: SubRoute, walk: SubRoute) = "$ROUTE_PREFIX/${
            encode("${drive.id}", UTF_8)
        }/${
            encode("${walk.id}", UTF_8)
        }"
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
