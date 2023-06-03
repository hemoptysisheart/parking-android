package com.github.hemoptysisheart.parking.app.ui.interaction

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.ui.page.MainPage
import com.github.hemoptysisheart.parking.app.ui.page.NavigationPage
import com.github.hemoptysisheart.parking.app.ui.page.SearchPage
import com.github.hemoptysisheart.parking.app.ui.page.SelectRoutePage

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun NavigationGraph() {
    val commonInteraction = CommonInteraction(
        context = LocalContext.current,
        navController = rememberNavController(),
        softwareKeyboardController = LocalSoftwareKeyboardController.current
    )
    val mainInteraction = MainInteraction(commonInteraction)
    val searchInteraction = SearchInteraction(commonInteraction)
    val selectRouteInteraction = SelectRouteInteraction(commonInteraction)
    val navigationInteraction = NavigationInteraction(commonInteraction)

    NavHost(navController = commonInteraction.navController, startDestination = MainInteraction.NAME) {
        composable(MainInteraction.ROUTE) {
            MainPage(mainInteraction)
        }

        composable(route = SearchInteraction.ROUTE) {
            SearchPage(searchInteraction)
        }

        composable(route = SelectRouteInteraction.ROUTE, arguments = SelectRouteInteraction.ARGUMENTS) {
            SelectRoutePage(selectRouteInteraction)
        }

        composable(route = NavigationInteraction.ROUTE, arguments = NavigationInteraction.ARGUMENTS) {
            NavigationPage(navigationInteraction)
        }
    }
}
