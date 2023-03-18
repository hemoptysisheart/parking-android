package com.github.hemoptysisheart.parking.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.hemoptysisheart.parking.app.navigation.ParkingNavHost
import com.github.hemoptysisheart.parking.core.logging.logArgsD
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        logArgsD(TAG, "onCreate", "savedInstanceState" to savedInstanceState)
        super.onCreate(savedInstanceState)

        setContent {
            ParkingTheme {
                ParkingNavHost()
            }
        }
    }
}
