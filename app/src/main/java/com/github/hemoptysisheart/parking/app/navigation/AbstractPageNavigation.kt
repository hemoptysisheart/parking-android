package com.github.hemoptysisheart.parking.app.navigation

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavController
import com.github.hemoptysisheart.parking.core.util.Logger

abstract class AbstractPageNavigation(
    protected val navController: NavController
) {
    companion object {
        internal const val TAG = "Navigation"
        val LOGGER = Logger(TAG)
    }

    @OptIn(ExperimentalComposeUiApi::class)
    val hideKeyboard: (SoftwareKeyboardController?) -> Unit = {
        if (null != it) {
            it.hide()
        } else {
            LOGGER.e(
                "#hideKeyboard controller is null. " +
                        "can not control software keyboard or software keyboard does not exist."
            )
        }
    }

    val onBack: () -> Unit = {
        LOGGER.v("#onBack called.")
        navController.popBackStack()
    }
}
