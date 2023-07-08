package com.github.hemoptysisheart.parking.app.ui.interaction.wizard

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction
import com.github.hemoptysisheart.parking.app.ui.page.wizard.InstructionPage
import com.github.hemoptysisheart.parking.app.ui.page.wizard.LocationPermissionPage

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun WizardNavigationGraph() {
    val commonInteraction = CommonInteraction(
        context = LocalContext.current,
        navController = rememberNavController(),
        softwareKeyboardController = LocalSoftwareKeyboardController.current
    )
    val instructionInteraction = InstructionInteraction(commonInteraction)
    val locationPermissionInteraction = LocationPermissionInteraction(commonInteraction)

    NavHost(navController = commonInteraction.navController, startDestination = InstructionInteraction.NAME) {
        composable(route = InstructionInteraction.ROUTE_PATTERN) {
            InstructionPage(instructionInteraction)
        }
        composable(route = LocationPermissionInteraction.ROUTE_PATTERN) {
            LocationPermissionPage(locationPermissionInteraction)
        }
    }
}
