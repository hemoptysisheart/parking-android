package com.github.hemoptysisheart.parking.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.launcher.LauncherInteraction
import com.github.hemoptysisheart.parking.app.ui.page.launcher.LauncherPage
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import dagger.hilt.android.AndroidEntryPoint

/**
 * 앱 시작 액티비티.
 *
 * 앱의 첫 인상을 제공하고, 앱 기동에 필요한 시간을 벌어준다.
 */
@AndroidEntryPoint
class LauncherActivity : ComponentActivity() {
    companion object {
        private val LOGGER = AndroidLogger(LauncherActivity::class)
    }

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        LOGGER.i("#onCreate args : savedInstanceState=$savedInstanceState")
        super.onCreate(savedInstanceState)

        setContent {
            ParkingTheme {
                LauncherPage(
                        LauncherInteraction(
                                BaseInteraction(this, rememberNavController(), LocalSoftwareKeyboardController.current)
                        )
                )
            }
        }
    }
}
