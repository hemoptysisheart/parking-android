package com.github.hemoptysisheart.parking.app.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import java.util.*

class NavigationPageNavigation(
    navController: NavController
) : AbstractPageNavigation(navController) {
    @Suppress("MemberVisibilityCanBePrivate")
    companion object {
        const val NAME = "Navigation"

        const val ARG_ROUTE_ID = "routeId"

        const val ROUTE = "$NAME/{$ARG_ROUTE_ID}"

        val ARGUMENTS = listOf(
            navArgument(ARG_ROUTE_ID) { type = NavType.StringType }
        )

        fun arguments(handle: SavedStateHandle): UUID {
            val id = UUID.fromString(
                handle[ARG_ROUTE_ID]
                    ?: throw IllegalArgumentException("$ARG_ROUTE_ID does not exist.")
            )
            LOGGER.i("#arguments return : $id")
            return id
        }
    }

    /**
     * 안내를 끝내고 초기 화면으로 돌아간다.
     */
    val onClose: () -> Unit = {
        navController.navigate(MainPageNavigation.ROUTE) {
            popUpTo(MainPageNavigation.ROUTE)
            launchSingleTop = true
        }
    }
}