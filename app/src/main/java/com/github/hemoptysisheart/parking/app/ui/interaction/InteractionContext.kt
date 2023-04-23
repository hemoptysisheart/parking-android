package com.github.hemoptysisheart.parking.app.ui.interaction

import android.content.Context
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavHostController

@OptIn(ExperimentalComposeUiApi::class)
data class InteractionContext(
    val context: Context,
    val navController: NavHostController,
    val softwareKeyboardController: SoftwareKeyboardController?
)
