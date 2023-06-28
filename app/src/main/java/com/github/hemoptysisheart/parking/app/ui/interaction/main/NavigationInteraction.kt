package com.github.hemoptysisheart.parking.app.ui.interaction.main

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction
import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction.Companion.LOGGER
import com.github.hemoptysisheart.parking.app.ui.interaction.Interaction
import com.github.hemoptysisheart.parking.app.ui.interaction.NavArgs
import java.util.*
import java.util.Objects.requireNonNull

class NavigationInteraction(commonInteraction: CommonInteraction) : Interaction by commonInteraction {
    @Suppress("MemberVisibilityCanBePrivate")
    companion object {
        const val NAME = "Navigation"

        const val ARG_ROUTE_ID = "routeId"

        const val ROUTE = "$NAME/{$ARG_ROUTE_ID}"

        val ARGUMENTS = listOf(
            navArgument(ARG_ROUTE_ID) { type = NavType.StringType }
        )

        val navArgs = NavArgs<UUID> {
            val id = UUID.fromString(requireNonNull(it[ARG_ROUTE_ID], "$ARG_ROUTE_ID does not exist."))
            LOGGER.i("#navArgs return : $id")
            id
        }
    }

    /**
     * 안내를 끝내고 초기 화면으로 돌아간다.
     */
    fun onClose() {
        navController.navigate(MainInteraction.ROUTE) {
            popUpTo(MainInteraction.ROUTE)
            launchSingleTop = true
        }
    }
}