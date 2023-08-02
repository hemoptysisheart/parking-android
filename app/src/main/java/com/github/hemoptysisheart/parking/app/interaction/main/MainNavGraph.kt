package com.github.hemoptysisheart.parking.app.interaction.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.ProgressIndicator
import com.github.hemoptysisheart.parking.app.ui.page.main.*

/**
 * 메인 네비게이션 그래프.
 */
@Composable
fun MainNavGraph(baseInteraction: BaseInteraction) {
    // interactions : set up navigation graph
    val landingMap = LandingMapInteraction(baseInteraction)
    val destinationSearch = DestinationSearchInteraction(baseInteraction)
    val selectParing = SelectParingInteraction(baseInteraction)
    val routeNavigation = RouteNavigationInteraction(baseInteraction)

    val setting = SettingInteraction(baseInteraction)
    val searchDestinationFilter = SearchDestinationFilterInteraction(baseInteraction)
    val developerSetting = DeveloperSettingInteraction(baseInteraction)

    // ui
    Column(Modifier.fillMaxSize()) {
        ProgressIndicator(true)
        NavHost(
            navController = baseInteraction.navController,
            startDestination = LandingMapInteraction.ROUTE_PATTERN,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(LandingMapInteraction.ROUTE_PATTERN) {
                LandingMapPage(landingMap)
            }
            composable(DestinationSearchInteraction.ROUTE_PATTERN) {
                DestinationSearchPage(destinationSearch)
            }
            composable(SettingInteraction.ROUTE_PATTERN) {
                SettingPage(setting)
            }
            composable(SelectParingInteraction.ROUTE_PATTERN) {
                SelectParkingPage(selectParing)
            }
            composable(RouteNavigationInteraction.ROUTE_PATTERN) {
                RouteNavigationPage(routeNavigation)
            }
            composable(SearchDestinationFilterInteraction.ROUTE_PATTERN) {
                SearchDestinationFilterPage(searchDestinationFilter)
            }
            composable(DeveloperSettingInteraction.ROUTE_PATTERN) {
                DeveloperSettingPage(developerSetting)
            }
        }
    }
}
