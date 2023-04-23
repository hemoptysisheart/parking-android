package com.github.hemoptysisheart.parking.app.ui.interaction

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.compose.rememberNavController

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun rememberInteractionContext(): InteractionContext {
    val context = LocalContext.current
    val navController = rememberNavController()
    val softwareKeyboardController = LocalSoftwareKeyboardController.current

    return remember { InteractionContext(context, navController, softwareKeyboardController) }
}

@Composable
fun rememberMainInteraction(context: InteractionContext): MainInteraction {
    return remember { MainInteraction(context) }
}

@Composable
fun rememberSearchInteraction(context: InteractionContext): SearchInteraction {
    return remember { SearchInteraction(context) }
}

@Composable
fun rememberSelectRouteInteraction(context: InteractionContext): SelectRouteInteraction {
    return remember { SelectRouteInteraction(context) }
}

@Composable
fun rememberNavigationInteraction(context: InteractionContext): NavigationInteraction {
    return remember { NavigationInteraction(context) }
}
