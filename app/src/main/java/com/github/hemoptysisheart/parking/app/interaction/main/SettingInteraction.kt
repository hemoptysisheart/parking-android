package com.github.hemoptysisheart.parking.app.interaction.main

import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

class SettingInteraction(
    private val base: BaseInteraction
) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(SettingInteraction::class)
        const val ROUTE_PATTERN = "setting"

    }

    fun gotoSearchDestinationFilter() {
        LOGGER.i("#gotoSearchDestinationFilter called.")

        base.navController.navigate(SearchDestinationFilterInteraction.ROUTE_PATTERN)
    }
}
