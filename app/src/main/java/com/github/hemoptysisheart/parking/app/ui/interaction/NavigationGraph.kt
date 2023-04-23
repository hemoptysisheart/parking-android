package com.github.hemoptysisheart.parking.app.ui.interaction

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.hemoptysisheart.parking.app.ui.page.MainPage
import com.github.hemoptysisheart.parking.app.ui.page.NavigationPage
import com.github.hemoptysisheart.parking.app.ui.page.SearchPage
import com.github.hemoptysisheart.parking.app.ui.page.SelectRoutePage

@Composable
fun NavigationGraph() {
    val context = rememberInteractionContext()

    NavHost(navController = context.navController, startDestination = MainInteraction.NAME) {
        composable(MainInteraction.ROUTE) {
            MainPage(rememberMainInteraction(context))
        }

        composable(route = SearchInteraction.ROUTE) {
            SearchPage(rememberSearchInteraction(context))
        }

        composable(route = SelectRouteInteraction.ROUTE, arguments = SelectRouteInteraction.ARGUMENTS) {
            SelectRoutePage(rememberSelectRouteInteraction(context))
        }

        composable(route = NavigationInteraction.ROUTE, arguments = NavigationInteraction.ARGUMENTS) {
            NavigationPage(rememberNavigationInteraction(context))
        }
    }
}
