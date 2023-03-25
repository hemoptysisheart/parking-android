package com.github.hemoptysisheart.parking.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.app.ui.page.LauncherPage
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * 앱 시작 액티비티.
 */
@AndroidEntryPoint
class LauncherActivity : ComponentActivity() {
    companion object {
        private const val TAG = "LauncherActivity"
        private val LOGGER = Logger(TAG)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        LOGGER.v("#onCreate args : savedInstanceState=$savedInstanceState")
        super.onCreate(savedInstanceState)

        setContent {
            ParkingTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    LauncherPage()
                }
            }
        }
    }
}
