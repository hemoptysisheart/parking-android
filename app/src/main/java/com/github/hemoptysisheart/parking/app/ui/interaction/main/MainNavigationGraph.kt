package com.github.hemoptysisheart.parking.app.ui.interaction.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction
import com.github.hemoptysisheart.parking.app.ui.page.main.MainPage
import com.github.hemoptysisheart.parking.app.ui.page.main.NavigationPage
import com.github.hemoptysisheart.parking.app.ui.page.main.SearchDestinationPage
import com.github.hemoptysisheart.parking.app.ui.page.main.SelectRoutePage

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun MainNavigationGraph() {
    val commonInteraction = CommonInteraction(
        context = LocalContext.current,
        navController = rememberNavController(),
        softwareKeyboardController = LocalSoftwareKeyboardController.current
    )
    val mainInteraction = MainInteraction(commonInteraction)
    val searchDestinationPageInteraction = SearchDestinationPageInteraction(commonInteraction)
    val selectRouteInteraction = SelectRouteInteraction(commonInteraction)
    val navigationInteraction = NavigationInteraction(commonInteraction)

    NavHost(navController = commonInteraction.navController, startDestination = MainInteraction.NAME) {
        composable(MainInteraction.ROUTE) {
            MainPage(mainInteraction)
        }

        composable(route = SearchDestinationPageInteraction.ROUTE) {
            SearchDestinationPage(searchDestinationPageInteraction)
        }

        composable(route = SelectRouteInteraction.ROUTE, arguments = SelectRouteInteraction.ARGUMENTS) {
            SelectRoutePage(selectRouteInteraction)
        }

        composable(route = NavigationInteraction.ROUTE, arguments = NavigationInteraction.ARGUMENTS) {
            NavigationPage(navigationInteraction)
        }
    }
}
