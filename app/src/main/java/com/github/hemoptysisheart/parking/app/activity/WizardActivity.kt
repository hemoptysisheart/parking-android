package com.github.hemoptysisheart.parking.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.wizard.WizardNavGraph
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import dagger.hilt.android.AndroidEntryPoint

/**
 * 마법사 액티비티
 *
 * 앱 기본 설정과 사용 안내를 제공한다.
 */
@AndroidEntryPoint
class WizardActivity : ComponentActivity() {
    companion object {
        private val LOGGER = AndroidLogger(WizardActivity::class)
    }

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        LOGGER.i("#onCreate args : savedInstanceState=$savedInstanceState")
        super.onCreate(savedInstanceState)

        setContent {
            ParkingTheme {
                WizardNavGraph(
                        BaseInteraction(this, rememberNavController(), LocalSoftwareKeyboardController.current)
                )
            }
        }
    }
}
