package com.github.hemoptysisheart.parking.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.hemoptysisheart.parking.app.interaction.baseInteraction
import com.github.hemoptysisheart.parking.app.interaction.wizard.WizardNavGraph
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WizardActivity : ComponentActivity() {
    companion object {
        private const val TAG = "WizardActivity"
        private val LOGGER = AndroidLogger(TAG)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        LOGGER.i("#onCreate args : savedInstanceState=$savedInstanceState")
        super.onCreate(savedInstanceState)

        setContent {
            ParkingTheme {
                WizardNavGraph(baseInteraction(this))
            }
        }
    }
}