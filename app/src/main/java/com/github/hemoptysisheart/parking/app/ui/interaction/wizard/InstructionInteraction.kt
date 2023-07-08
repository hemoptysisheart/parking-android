package com.github.hemoptysisheart.parking.app.ui.interaction.wizard

import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction
import com.github.hemoptysisheart.parking.app.ui.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.Logger

class InstructionInteraction(commonInteraction: CommonInteraction) : Interaction by commonInteraction {
    companion object {
        private const val TAG = "InstructionInteraction"
        private val LOGGER = Logger(TAG)

        const val NAME = "wizard/instruction"

        const val ROUTE_PATTERN = NAME
    }

    fun skip() {
        LOGGER.d("#skip called.")
    }

    fun next() {
        LOGGER.d("#next called.")

        navController.navigate(LocationPermissionInteraction.ROUTE_PATTERN)
    }
}
