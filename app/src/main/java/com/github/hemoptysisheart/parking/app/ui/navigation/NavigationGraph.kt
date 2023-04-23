package com.github.hemoptysisheart.parking.app.ui.navigation

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

    val main = remember { MainPageNavigation(navController) }
    val search = remember { SearchPageNavigation(navController) }
    val select = remember { SelectRoutePageNavigation(navController) }
    val navigation = remember { NavigationPageNavigation(navController) }

    NavHost(navController = navController, startDestination = MainPageNavigation.NAME) {
        composable(MainPageNavigation.ROUTE) {
            MainPage(main)
        }

        composable(route = SearchPageNavigation.ROUTE) {
            SearchPage(search)
        }

        composable(route = SelectRoutePageNavigation.ROUTE, arguments = SelectRoutePageNavigation.ARGUMENTS) {
            SelectRoutePage(select)
        }

        composable(route = NavigationPageNavigation.ROUTE, arguments = NavigationPageNavigation.ARGUMENTS) {
            NavigationPage(navigation)
        }
    }
}
