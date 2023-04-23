package com.github.hemoptysisheart.parking.app.ui.interaction

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.ui.page.MainPage
import com.github.hemoptysisheart.parking.app.ui.page.NavigationPage
import com.github.hemoptysisheart.parking.app.ui.page.SearchPage
import com.github.hemoptysisheart.parking.app.ui.page.SelectRoutePage

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    val main = remember { MainInteraction(navController) }
    val search = remember { SearchInteraction(navController) }
    val select = remember { SelectRouteInteraction(navController) }
    val navigation = remember { NavigationInteraction(navController) }

    NavHost(navController = navController, startDestination = MainInteraction.NAME) {
        composable(MainInteraction.ROUTE) {
            MainPage(main)
        }

        composable(route = SearchInteraction.ROUTE) {
            SearchPage(search)
        }

        composable(route = SelectRouteInteraction.ROUTE, arguments = SelectRouteInteraction.ARGUMENTS) {
            SelectRoutePage(select)
        }

        composable(route = NavigationInteraction.ROUTE, arguments = NavigationInteraction.ARGUMENTS) {
            NavigationPage(navigation)
        }
    }
}
