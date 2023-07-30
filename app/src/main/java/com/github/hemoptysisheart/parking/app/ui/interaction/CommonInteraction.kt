package com.github.hemoptysisheart.parking.app.ui.interaction

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavHostController
import com.github.hemoptysisheart.parking.core.util.Logger

@OptIn(ExperimentalComposeUiApi::class)
class CommonInteraction(
    private val context: Context,
    private val navController: NavHostController,
    private val softwareKeyboardController: SoftwareKeyboardController?
) : Interaction {
    companion object {
        private const val TAG = "CommonInteraction"

        private val LOGGER = Logger(TAG)
    }

    override fun goBack() {
        LOGGER.d("#goBack called.")

        navController.popBackStack()
    }

    override fun openWebPage(uri: Uri) {
        LOGGER.d("#openWebPage args : uri=$uri")

        context.startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    override fun showSoftwareKeyboard() {
        LOGGER.d("#showSoftwareKeyboard called.")

        softwareKeyboardController?.show()
    }

    override fun hideSoftwareKeyboard() {
        LOGGER.d("#hideSoftwareKeyboard called.")

        softwareKeyboardController?.hide()
    }
}
