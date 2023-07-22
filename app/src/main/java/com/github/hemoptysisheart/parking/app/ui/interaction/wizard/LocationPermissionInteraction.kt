package com.github.hemoptysisheart.parking.app.ui.interaction.wizard

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.github.hemoptysisheart.parking.app.activity.MainActivity
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

    fun gotoPermissionSetting() {
        LOGGER.d("#gotoPermissionSetting called.")

        val intent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", context.packageName, null)
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    fun skip() {
        LOGGER.d("#skip called.")

        context.startActivity(Intent(context, MainActivity::class.java))
    }

    fun next() {
        LOGGER.d("#next called.")
    }
}
