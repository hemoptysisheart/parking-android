package com.github.hemoptysisheart.parking.app.interaction.main

import androidx.lifecycle.SavedStateHandle
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.domain.common.toIdentifier
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.route.SubRoute
import java.net.URLEncoder.encode
import java.nio.charset.StandardCharsets.UTF_8

/**
 * [경로 안내](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-693)
 */
class RouteNavigationInteraction(
        private val base: BaseInteraction
) : Interaction by base {
    data class Args(
            val drive: Identifier,
            val walk: Identifier
    )

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

        fun args(savedStateHandle: SavedStateHandle): Args {
            val drive: String = savedStateHandle[ARG_DRIVE]
                    ?: throw IllegalArgumentException("$ARG_DRIVE does not exist.")
            val walk: String = savedStateHandle[ARG_WALK]
                    ?: throw IllegalArgumentException("$ARG_WALK does not exist.")
            val args = Args(
                    drive.toIdentifier(),
                    walk.toIdentifier()
            )
            LOGGER.d("#args : $savedStateHandle => $args")
            return args
        }
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
