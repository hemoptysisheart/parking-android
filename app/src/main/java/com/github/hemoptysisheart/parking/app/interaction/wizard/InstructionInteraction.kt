package com.github.hemoptysisheart.parking.app.interaction.wizard

import android.content.Intent
import com.github.hemoptysisheart.parking.app.activity.MainActivity
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

/**
 * 마법사 - 앱 소개(`wizard/instruction`)
 *
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54366-25117&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54303-34815&mode=design
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-649
 */
class InstructionInteraction(
        private val base: BaseInteraction
) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(InstructionInteraction::class)

        const val ROUTE_PATTERN = "wizard/instruction"
    }

    fun gotoLocation() {
        LOGGER.i("#gotoLocation called.")

        base.navController.navigate(LocationInteraction.ROUTE_PATTERN)
    }

    fun close() {
        LOGGER.i("#close called.")

        base.activity.startActivity(Intent(base.activity, MainActivity::class.java))
        base.activity.finish()
    }
}
