package com.github.hemoptysisheart.parking.app.interaction.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.ui.page.main.DestinationSearchPage
import com.github.hemoptysisheart.parking.app.ui.page.main.DeveloperSettingPage
import com.github.hemoptysisheart.parking.app.ui.page.main.LandingMapPage
import com.github.hemoptysisheart.parking.app.ui.page.main.RouteNavigationPage
import com.github.hemoptysisheart.parking.app.ui.page.main.SearchSettingPage
import com.github.hemoptysisheart.parking.app.ui.page.main.SelectParkingPage
import com.github.hemoptysisheart.parking.app.ui.page.main.SelectRoutePage
import com.github.hemoptysisheart.parking.app.ui.page.main.SettingPage
import com.github.hemoptysisheart.parking.app.ui.template.GlobalHeader

/**
 * 메인 네비게이션 그래프.
 */
@Composable
fun MainNavGraph(baseInteraction: BaseInteraction) {
    // interactions : set up navigation graph
    val globalHeader = GlobalHeaderInteraction(baseInteraction)

    val landingMap = LandingMapInteraction(baseInteraction)
    val destinationSearch = DestinationSearchInteraction(baseInteraction)
    val selectParking = SelectParkingInteraction(baseInteraction)
    val selectRoute = SelectRouteInteraction(baseInteraction)
    val routeNavigation = RouteNavigationInteraction(baseInteraction)

    val setting = SettingInteraction(baseInteraction)
    val searchDestinationFilter = SearchSettingInteraction(baseInteraction)
    val developerSetting = DeveloperSettingInteraction(baseInteraction)

    // ui
    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
    ) {
        GlobalHeader(globalHeader)

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
            composable(SelectParkingInteraction.ROUTE_PATTERN) {
                SelectParkingPage(selectParking)
            }
            composable(SelectRouteInteraction.ROUTE_PATTERN) {
                SelectRoutePage(selectRoute)
            }
            composable(RouteNavigationInteraction.ROUTE_PATTERN) {
                RouteNavigationPage(routeNavigation)
            }
            composable(SearchSettingInteraction.ROUTE_PATTERN) {
                SearchSettingPage(searchDestinationFilter)
            }
            composable(DeveloperSettingInteraction.ROUTE_PATTERN) {
                DeveloperSettingPage(developerSetting)
            }
        }
    }
}
