package com.github.hemoptysisheart.parking.app.interaction.main

import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.place.Place
import java.net.URLEncoder
import java.nio.charset.StandardCharsets.UTF_8

/**
 * [주차장 선택](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-673)
 */
class SelectParkingInteraction(
        private val base: BaseInteraction
) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(SelectParkingInteraction::class)
        private const val ROUTE_PREFIX = "main/selectParking"

        const val ARG_DESTINATION = "destination"
        const val ROUTE_PATTERN = "$ROUTE_PREFIX/{$ARG_DESTINATION}"

        fun route(place: Place): String {
            val route = "$ROUTE_PREFIX/${URLEncoder.encode("${place.id.toURI()}", UTF_8)}"
            LOGGER.d("#route : $place => $route")
            return route
        }
    }

    fun gotoSelectRoute() {
        LOGGER.i("#gotoSelectRoute called.")

        base.navController.navigate(SelectRouteInteraction.ROUTE_PATTERN)
    }
}
