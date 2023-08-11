package com.github.hemoptysisheart.parking.app.interaction.wizard

import android.content.Intent
import com.github.hemoptysisheart.parking.app.activity.MainActivity
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

/**
 * [마법사](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-649)
 */
class LocationInteraction(
        private val base: BaseInteraction
) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(LocationInteraction::class)

        const val ROUTE_PATTERN = "wizard/location"
    }

    fun openAppSetting() {
        LOGGER.i("#openAppSetting called.")
    }

    fun close() {
        LOGGER.i("#close called.")

        base.activity.startActivity(Intent(base.activity, MainActivity::class.java))
        base.activity.finish()
    }
}
