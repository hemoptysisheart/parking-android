package com.github.hemoptysisheart.parking.app.ui.interaction

import androidx.compose.ui.ExperimentalComposeUiApi
import com.github.hemoptysisheart.parking.core.util.Logger

@OptIn(ExperimentalComposeUiApi::class)
abstract class AbstractInteraction(
    protected val context: InteractionContext
) {
    companion object {
        internal const val TAG = "Interaction"
        val LOGGER = Logger(TAG)
    }

    val onBack: () -> Unit = {
        LOGGER.v("#onBack called.")
        context.navController.popBackStack()
    }

    val showSoftwareKeyboard: () -> Unit = {
        LOGGER.v("#showSoftwareKeyboard called.")
        context.softwareKeyboardController?.show()
    }

    val hideSoftwareKeyboard: () -> Unit = {
        LOGGER.v("#hideSoftwareKeyboard called.")
        context.softwareKeyboardController?.hide()
    }
}
