package com.github.hemoptysisheart.parking.app.ui.interaction

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavHostController
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

@OptIn(ExperimentalComposeUiApi::class)
class CommonInteraction(
    private val context: Context,
    private val navController: NavHostController,
    private val softwareKeyboardController: SoftwareKeyboardController?
) : Interaction {
    companion object {
        private val LOGGER = AndroidLogger(CommonInteraction::class)
    }

    override fun goBack() {
        LOGGER.i("#goBack called.")

        navController.popBackStack()
    }

    override fun openWebPage(uri: Uri) {
        LOGGER.i("#openWebPage args : uri=$uri")

        context.startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    override fun showSoftwareKeyboard() {
        LOGGER.i("#showSoftwareKeyboard called.")

        softwareKeyboardController?.show()
    }

    override fun hideSoftwareKeyboard() {
        LOGGER.i("#hideSoftwareKeyboard called.")

        softwareKeyboardController?.hide()
    }

    override fun toString() =
        "context=$context, navController=$navController, softwareKeyboardController=$softwareKeyboardController"
}
