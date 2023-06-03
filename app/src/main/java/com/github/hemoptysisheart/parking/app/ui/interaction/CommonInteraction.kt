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

    override val onBack: () -> Unit = {
        LOGGER.v("#onBack called.")
        navController.popBackStack()
    }

    override val showSoftwareKeyboard: () -> Unit = {
        LOGGER.v("#showSoftwareKeyboard called.")
        softwareKeyboardController?.show()
    }

    override val hideSoftwareKeyboard: () -> Unit = {
        LOGGER.v("#hideSoftwareKeyboard called.")
        softwareKeyboardController?.hide()
    }
}
