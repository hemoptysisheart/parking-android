package com.github.hemoptysisheart.parking.app.interaction.main

import android.content.Intent
import com.github.hemoptysisheart.parking.app.activity.WizardActivity
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

/**
 * `main/settings`
 *
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54310-34798&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54406-992&mode=design
 */
class SettingsInteraction(
        private val base: BaseInteraction
) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(SettingsInteraction::class)

        const val ROUTE_PATTERN = "main/settings"
    }

    fun gotoSearchSetting() {
        LOGGER.i("#gotoSearchSetting called.")

        base.navController.navigate(SearchSettingInteraction.ROUTE_PATTERN)
    }

    fun gotoWizard() {
        LOGGER.i("#gotoWizard called.")

        base.activity.startActivity(Intent(base.activity, WizardActivity::class.java))
    }

    fun gotoDeveloperSetting() {
        LOGGER.i("#gotoDeveloperSetting called.")

        base.navController.navigate(DeveloperSettingInteraction.ROUTE_PATTERN)
    }

    fun gotoAboutApp() {
        LOGGER.i("#gotoAboutApp called.")

        base.navController.navigate(AboutAppInteraction.ROUTE_PATTERN)
    }
}
