package com.github.hemoptysisheart.parking.app.ui.interaction

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction.Companion.LOGGER
import com.github.hemoptysisheart.parking.domain.Route

class SelectRouteInteraction(commonInteraction: CommonInteraction) : Interaction by commonInteraction {
    companion object {
        const val NAME = "SelectRoute"

        const val ARG_DESTINATION_ID = "destinationId"

        const val ROUTE = "$NAME/{$ARG_DESTINATION_ID}"

        val ARGUMENTS = listOf(
            navArgument(ARG_DESTINATION_ID) { type = NavType.StringType }
        )

        val navArgs = NavArgs {
            val id = it.get<String>(ARG_DESTINATION_ID)
                ?: throw IllegalStateException("$ARG_DESTINATION_ID is not exist.")
            LOGGER.v("#navArgs : $id")
            id
        }
    }

    fun gotoNavigation(route: Route) {
        LOGGER.d("#gotoNavigation args : route=$route")

        navController.navigate("${NavigationInteraction.NAME}/${route.id}")
    }
}
