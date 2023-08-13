package com.github.hemoptysisheart.parking.app.interaction.main

import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

/**
 * [랜딩 맵](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-645)
 */
class LandingMapInteraction(
        private val base: BaseInteraction
) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(LandingMapInteraction::class)

        const val ROUTE_PATTERN = "main/landingMap"
    }

    fun gotoDestinationSearch() {
        LOGGER.i("#gotoDestinationSearch called.")

        base.navController.navigate(DestinationSearchInteraction.ROUTE_PATTERN)
    }

    fun gotoSetting() {
        LOGGER.i("#gotoSetting called.")

        base.navController.navigate(SettingsInteraction.ROUTE_PATTERN)
    }
}
