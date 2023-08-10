package com.github.hemoptysisheart.parking.app.interaction

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavHostController
import com.github.hemoptysisheart.parking.core.util.AndroidLogger

@OptIn(ExperimentalComposeUiApi::class)
class BaseInteraction(
        internal val activity: Activity,
        val navController: NavHostController,
        private val softwareKeyboardController: SoftwareKeyboardController?
) : Interaction {
    companion object {
        private val LOGGER = AndroidLogger(BaseInteraction::class)
    }

    override fun goBack() {
        LOGGER.i("#goBack called.")

        navController.popBackStack()
    }

    override fun openWebPage(uri: Uri) {
        LOGGER.i("#openWebPage args : uri=$uri")

        activity.startActivity(Intent(ACTION_VIEW, uri))
    }

    override fun showSoftwareKeyboard() {
        LOGGER.i("#showSoftwareKeyboard called.")

        softwareKeyboardController?.show()
    }

    override fun hideSoftwareKeyboard() {
        LOGGER.i("#hideSoftwareKeyboard called.")

        softwareKeyboardController?.hide()
    }
}