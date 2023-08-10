package com.github.hemoptysisheart.parking.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.main.MainNavGraph
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import dagger.hilt.android.AndroidEntryPoint

/**
 * 메인 액티비티.
 *
 * 몇몇 예외를 제외한 거의 대부분의 기능을 제공한다.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    companion object {
        private val LOGGER = AndroidLogger(MainActivity::class)
    }

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        LOGGER.i("#onCreate args : savedInstanceState=$savedInstanceState")
        super.onCreate(savedInstanceState)

        setContent {
            ParkingTheme {
                MainNavGraph(
                        BaseInteraction(this, rememberNavController(), LocalSoftwareKeyboardController.current)
                )
            }
        }
    }
}
