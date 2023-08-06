package com.github.hemoptysisheart.parking.app.interaction.launcher

import android.content.Intent
import com.github.hemoptysisheart.parking.app.activity.MainActivity
import com.github.hemoptysisheart.parking.app.activity.WizardActivity
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

/**
 * [스플래시](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-641)
 */
class LauncherInteraction(
        private val baseInteraction: BaseInteraction
) : Interaction by baseInteraction {
    companion object {
        private val LOGGER = AndroidLogger(LauncherInteraction::class)
    }

    fun gotoLandingMap() {
        LOGGER.i("#gotoLandingMap called.")

        baseInteraction.activity.startActivity(Intent(baseInteraction.activity, MainActivity::class.java))
        baseInteraction.activity.finish()
    }

    fun gotoWizard() {
        LOGGER.i("#gotoWizard called.")

        baseInteraction.activity.startActivity(Intent(baseInteraction.activity, WizardActivity::class.java))
        baseInteraction.activity.finish()
    }
}