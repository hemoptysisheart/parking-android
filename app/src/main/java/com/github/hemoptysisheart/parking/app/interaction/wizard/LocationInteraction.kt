package com.github.hemoptysisheart.parking.app.interaction.wizard

import android.content.Intent
import com.github.hemoptysisheart.parking.app.activity.MainActivity
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

class LocationInteraction(
    private val base: BaseInteraction
) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(LocationInteraction::class)

        const val ROUTE_PATTERN = "wizard/location"
    }

    fun requestPermission() {
        LOGGER.i("#requestPermission called.")
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
