package com.github.hemoptysisheart.parking.app.navigation

import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.github.hemoptysisheart.parking.domain.Route

class SelectRoutePageNavigation(navController: NavController) : AbstractPageNavigation(navController) {
    companion object {
        const val NAME = "SelectRoute"

        const val ARG_DESTINATION_ID = "destinationId"

        const val ROUTE = "$NAME/{$ARG_DESTINATION_ID}"

        val ARGUMENTS = listOf(
            navArgument(ARG_DESTINATION_ID) { type = NavType.StringType }
        )
    }

    val gotoNavigation: (Route) -> Unit = {
        LOGGER.d("#gotoNavigation args : route=$it")
        navController.navigate("${NavigationPageNavigation.NAME}/$it") // TODO route.id 추가.
    }
}
