package com.github.hemoptysisheart.parking.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.hemoptysisheart.parking.app.ui.navigation.NavigationGraph
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.core.logging.logArgsD
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
                NavigationGraph()
            }
        }
    }
}
