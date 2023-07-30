package com.github.hemoptysisheart.parking.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.hemoptysisheart.parking.app.ui.interaction.launcher.LauncherInteraction
import com.github.hemoptysisheart.parking.app.ui.interaction.rememberCommonInteraction
import com.github.hemoptysisheart.parking.app.ui.page.launcher.LauncherPage
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import dagger.hilt.android.AndroidEntryPoint

/**
 * 앱 시작 액티비티.
 */
@AndroidEntryPoint
class LauncherActivity : ComponentActivity() {
    companion object {
        private val LOGGER = AndroidLogger(LauncherActivity::class)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        LOGGER.i("#onCreate args : savedInstanceState=$savedInstanceState")
        super.onCreate(savedInstanceState)

        setContent {
            ParkingTheme {
                LauncherPage(LauncherInteraction(rememberCommonInteraction()))
            }
        }
    }
}
