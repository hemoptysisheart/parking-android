package com.github.hemoptysisheart.parking.app.interaction

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavDestination
import androidx.navigation.Navigator
import androidx.navigation.compose.rememberNavController

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun baseInteraction(
    activity: Activity,
    vararg navigators: Navigator<out NavDestination>
): BaseInteraction {
    val navController = rememberNavController(navigators = navigators)
    val keyboardController = LocalSoftwareKeyboardController.current
    return BaseInteraction(activity, navController, keyboardController)
}
