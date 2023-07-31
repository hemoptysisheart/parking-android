package com.github.hemoptysisheart.parking.app.interaction.main

import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

/**
 * [주차장 선택](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-673)
 */
class SelectParingInteraction(
    private val base: BaseInteraction
) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(SelectParingInteraction::class)

        const val ROUTE_PATTERN = "selectParking"
    }

    fun gotoSelectRoute() {
        LOGGER.i("#gotoSelectRoute called.")

        base.navController.navigate(SelectRouteInteraction.ROUTE_PATTERN)
    }
}
