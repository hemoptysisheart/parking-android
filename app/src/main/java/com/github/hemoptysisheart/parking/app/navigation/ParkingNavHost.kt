package com.github.hemoptysisheart.parking.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.ui.page.MainPage
import com.github.hemoptysisheart.parking.app.ui.page.SearchPage
import com.github.hemoptysisheart.parking.app.ui.page.SelectRoutePage

@Composable
fun ParkingNavHost() {
    val navController = rememberNavController()
    val main = remember { MainPageNavigation(navController) }
    val search = remember { SearchPageNavigation(navController) }
    val select = remember { SelectRoutePageNavigation(navController) }

    NavHost(navController = navController, startDestination = MainPageNavigation.NAME) {
        composable(MainPageNavigation.NAME) {
            MainPage(main)
        }

        composable(route = SearchPageNavigation.NAME) {
            SearchPage(search)
        }

        composable(route = SelectRoutePageNavigation.ROUTE, arguments = SelectRoutePageNavigation.ARGUMENTS) {
            SelectRoutePage(select)
        }
    }
}
