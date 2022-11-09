package com.github.hemoptysisheart.parking.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.ui.component.map.MapScreen
import com.github.hemoptysisheart.parking.app.ui.screen.SearchScreen

object Destination {
    /**
     * [com.github.hemoptysisheart.parking.app.ui.component.map.MapScreen]
     */
    const val MAP_SCREEN = "MAP_SCREEN"

    /**
     * [com.github.hemoptysisheart.parking.app.ui.screen.SearchScreen]
     */
    const val SEARCH_SCREEN = "SEARCH_SCREEN"
}

@Composable
fun MainNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, Destination.MAP_SCREEN) {
        composable(Destination.MAP_SCREEN) {
            MapScreen(navigateToSearch = {
                navController.navigate(Destination.SEARCH_SCREEN)
            })
        }

        composable(Destination.SEARCH_SCREEN) {
            SearchScreen()
        }
    }
}