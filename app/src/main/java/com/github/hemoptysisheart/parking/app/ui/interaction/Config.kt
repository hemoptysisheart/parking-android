package com.github.hemoptysisheart.parking.app.ui.interaction

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun rememberCommonInteraction(
    navController: NavHostController = rememberNavController()
): CommonInteraction {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    return remember {
        CommonInteraction(context, navController, keyboardController)
    }
}