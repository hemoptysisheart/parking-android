package com.github.hemoptysisheart.parking.app.navigation

import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument

class SelectRoutePageNavigation(navController: NavController) : AbstractPageNavigation(navController) {
    companion object {
        const val PARAM_ID = "id"

        const val NAME = "SelectRoute"

        const val ROUTE = "$NAME/{$PARAM_ID}"

        val ARGUMENTS = listOf(
            navArgument(PARAM_ID) { type = NavType.StringType }
        )
    }
}
