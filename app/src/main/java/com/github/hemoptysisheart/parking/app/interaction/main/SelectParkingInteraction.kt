package com.github.hemoptysisheart.parking.app.interaction.main

import androidx.lifecycle.SavedStateHandle
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.domain.common.toIdentifier
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.common.Identifier
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

        fun args(savedStateHandle: SavedStateHandle): Identifier {
            LOGGER.d { "#args args : savedStateHandle=$savedStateHandle" }

            val id: String = savedStateHandle[ARG_DESTINATION]
                    ?: throw IllegalArgumentException("$ARG_DESTINATION is null.")
            val identifier = id.toIdentifier()

            LOGGER.d("#args : $id => $identifier")
            return identifier
        }
    }

    fun gotoSelectRoute() {
        LOGGER.d("#gotoSelectRoute called.")

        base.navController.navigate(SelectRouteInteraction.ROUTE_PATTERN)
    }

    fun gotoSetting() {
        LOGGER.d("#gotoSetting called.")

        base.navController.navigate(SearchSettingInteraction.ROUTE_PATTERN)
    }
}
