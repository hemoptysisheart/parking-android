package com.github.hemoptysisheart.parking.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.app.ui.screen.LauncherScreen
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * 앱 시작 액티비티.
 */
@AndroidEntryPoint
class LauncherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParkingTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    LauncherScreen()
                }
            }
        }
    }
}
