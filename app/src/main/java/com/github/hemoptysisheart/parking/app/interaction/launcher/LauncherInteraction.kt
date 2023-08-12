package com.github.hemoptysisheart.parking.app.interaction.launcher

import android.content.Intent
import com.github.hemoptysisheart.parking.app.activity.MainActivity
import com.github.hemoptysisheart.parking.app.activity.WizardActivity
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

/**
 * 런처 화면(`launcher`)
 *
 * 앱을 실행하고 초기화에 필요한 시간을 벌면서 사용자에게 필요한 정보를 전달한다.
 *
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54316-24308&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54303-34813&mode=design
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-641
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