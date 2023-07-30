package com.github.hemoptysisheart.parking.app.interaction.wizard

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.ui.page.wizard.InstructionPage
import com.github.hemoptysisheart.parking.app.ui.page.wizard.LocationPage

@Composable
fun WizardNavGraph(baseInteraction: BaseInteraction) {
    val instruction = InstructionInteraction(baseInteraction)
    val location = LocationInteraction(baseInteraction)

    NavHost(navController = baseInteraction.navController, startDestination = InstructionInteraction.ROUTE_PATTERN) {
        composable(route = InstructionInteraction.ROUTE_PATTERN) {
            InstructionPage(interaction = instruction)
        }

        composable(route = LocationInteraction.ROUTE_PATTERN) {
            LocationPage(interaction = location)
        }
    }
}