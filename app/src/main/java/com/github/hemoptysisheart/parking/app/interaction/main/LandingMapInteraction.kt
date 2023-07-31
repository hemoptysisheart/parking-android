package com.github.hemoptysisheart.parking.app.interaction.main

import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

class LandingMapInteraction(private val base: BaseInteraction) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(LandingMapInteraction::class)

        const val ROUTE_PATTERN = "landingMap"
    }

    fun gotoDestinationSearch() {
        LOGGER.i("#gotoDestinationSearch called.")

        base.navController.navigate(DestinationSearchInteraction.ROUTE_PATTERN)
    }

    fun gotoSetting() {
        LOGGER.i("#gotoSetting called.")

        base.navController.navigate(SettingInteraction.ROUTE_PATTERN)
    }
}
