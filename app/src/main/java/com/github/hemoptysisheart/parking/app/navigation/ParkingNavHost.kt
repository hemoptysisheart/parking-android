package com.github.hemoptysisheart.parking.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.ui.page.MainPage
import com.github.hemoptysisheart.parking.app.ui.page.SearchPage
import com.github.hemoptysisheart.parking.app.ui.page.SelectRoutePage

@Composable
fun ParkingNavHost() {
    val navController = rememberNavController()
    val main = MainPageNavigation(navController)
    val search = SearchPageNavigation(navController)

    NavHost(navController = navController, startDestination = MainPageNavigation.NAME) {
        composable(MainPageNavigation.NAME) {
            MainPage(main)
        }

        composable(SearchPageNavigation.NAME) {
            SearchPage(search)
        }

        composable(SelectRoutePageNavigation.ROUTE, SelectRoutePageNavigation.ARGUMENTS) {
            SelectRoutePage()
        }
    }
}
