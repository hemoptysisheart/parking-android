package com.github.hemoptysisheart.parking.app.ui.interaction.launcher

import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction
import com.github.hemoptysisheart.parking.app.ui.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

class LauncherInteraction(
    commonInteraction: CommonInteraction
) : Interaction by commonInteraction {
    companion object {
        private val LOGGER = AndroidLogger(LauncherInteraction::class)
    }

    fun gotoLandingMap() {
        LOGGER.i("#gotoLandingMap called.")
    }

    fun gotoWizard() {
        LOGGER.i("#gotoWizard called.")
    }
}