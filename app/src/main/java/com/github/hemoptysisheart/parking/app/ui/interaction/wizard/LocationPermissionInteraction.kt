package com.github.hemoptysisheart.parking.app.ui.interaction.wizard

import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction
import com.github.hemoptysisheart.parking.app.ui.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.Logger

class LocationPermissionInteraction(commonInteraction: CommonInteraction) : Interaction by commonInteraction {
    companion object {
        private const val TAG = "LocationPermissionInteraction"
        private val LOGGER = Logger(TAG)

        const val NAME = "wizard/location"

        const val ROUTE_PATTERN = NAME
    }

    fun skip() {
        LOGGER.d("#skip called.")
    }

    fun next() {
        LOGGER.d("#next called.")
    }
}
