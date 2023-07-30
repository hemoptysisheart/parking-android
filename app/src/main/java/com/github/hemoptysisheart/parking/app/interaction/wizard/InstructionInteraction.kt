package com.github.hemoptysisheart.parking.app.interaction.wizard

import android.content.Intent
import com.github.hemoptysisheart.parking.app.activity.MainActivity
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

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
