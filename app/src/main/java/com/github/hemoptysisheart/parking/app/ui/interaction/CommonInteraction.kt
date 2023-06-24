package com.github.hemoptysisheart.parking.app.ui.interaction

import android.content.Context
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavHostController
import com.github.hemoptysisheart.parking.core.util.Logger

@OptIn(ExperimentalComposeUiApi::class)
class CommonInteraction(
    override val context: Context,
    override val navController: NavHostController,
    override val softwareKeyboardController: SoftwareKeyboardController?
) : Interaction {
    companion object {
        internal const val TAG = "Interaction"

        val LOGGER = Logger(TAG)
    }

    override fun onBack() {
        LOGGER.v("#onBack called.")
        navController.popBackStack()
    }

    override fun showSoftwareKeyboard() {
        LOGGER.v("#showSoftwareKeyboard called.")
        softwareKeyboardController?.show()
    }

    override fun hideSoftwareKeyboard() {
        LOGGER.v("#hideSoftwareKeyboard called.")
        softwareKeyboardController?.hide()
    }
}
