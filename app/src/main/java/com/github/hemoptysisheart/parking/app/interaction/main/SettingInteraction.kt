package com.github.hemoptysisheart.parking.app.interaction.main

import android.content.Intent
import com.github.hemoptysisheart.parking.app.activity.WizardActivity
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

class SettingInteraction(
    private val base: BaseInteraction
) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(SettingInteraction::class)
        const val ROUTE_PATTERN = "main/setting"

    }

    fun gotoSearchDestinationFilter() {
        LOGGER.i("#gotoSearchDestinationFilter called.")

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
}
