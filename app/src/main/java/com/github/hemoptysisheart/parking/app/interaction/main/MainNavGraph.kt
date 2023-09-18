package com.github.hemoptysisheart.parking.app.interaction.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction.Companion.ARG_RETURN_FROM
import com.github.hemoptysisheart.parking.app.ui.page.main.AboutAppPage
import com.github.hemoptysisheart.parking.app.ui.page.main.DestinationSearchPage
import com.github.hemoptysisheart.parking.app.ui.page.main.DeveloperSettingPage
import com.github.hemoptysisheart.parking.app.ui.page.main.LandingMapPage
import com.github.hemoptysisheart.parking.app.ui.page.main.RouteNavigationPage
import com.github.hemoptysisheart.parking.app.ui.page.main.SearchSettingPage
import com.github.hemoptysisheart.parking.app.ui.page.main.SelectParkingPage
import com.github.hemoptysisheart.parking.app.ui.page.main.SelectRoutePage
import com.github.hemoptysisheart.parking.app.ui.page.main.SettingsPage
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

    val setting = SettingsInteraction(baseInteraction)
    val searchDestinationFilter = SearchSettingInteraction(baseInteraction)
    val developerSetting = DeveloperSettingInteraction(baseInteraction)
    val aboutAppInteraction = AboutAppInteraction(baseInteraction)

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
            composable(
                    route = LandingMapInteraction.ROUTE_PATTERN,
                    arguments = listOf(
                            navArgument(ARG_RETURN_FROM) {
                                type = NavType.StringType
                                nullable = true
                                defaultValue = null
                            }
                    )
            ) {
                LandingMapPage(landingMap)
            }
            composable(
                    route = DestinationSearchInteraction.ROUTE_PATTERN,
                    arguments = listOf(
                            navArgument(ARG_RETURN_FROM) {
                                type = NavType.StringType
                                nullable = true
                                defaultValue = null
                            }
                    )
            ) {
                DestinationSearchPage(destinationSearch)
            }
            composable(
                    route = SelectParkingInteraction.ROUTE_PATTERN,
                    arguments = listOf(
                            navArgument(SelectParkingInteraction.ARG_DESTINATION) {
                                nullable = false
                                type = NavType.StringType
                            },
                            navArgument(ARG_RETURN_FROM) {
                                type = NavType.StringType
                                nullable = true
                                defaultValue = null
                            }
                    )
            ) {
                SelectParkingPage(selectParking)
            }
            composable(
                    route = SelectRouteInteraction.ROUTE_PATTERN,
                    arguments = listOf(
                            navArgument(SelectRouteInteraction.ARG_PARKING) {
                                nullable = false
                                type = NavType.StringType
                            },
                            navArgument(SelectRouteInteraction.ARG_DESTINATION) {
                                nullable = false
                                type = NavType.StringType
                            },
                            navArgument(ARG_RETURN_FROM) {
                                type = NavType.StringType
                                nullable = true
                                defaultValue = null
                            }
                    )
            ) {
                SelectRoutePage(selectRoute)
            }
            composable(
                    route = RouteNavigationInteraction.ROUTE_PATTERN,
                    arguments = listOf(
                            navArgument(RouteNavigationInteraction.ARG_DRIVE) {
                                nullable = false
                                type = NavType.StringType
                            },
                            navArgument(RouteNavigationInteraction.ARG_WALK) {
                                nullable = false
                                type = NavType.StringType
                            },
                            navArgument(ARG_RETURN_FROM) {
                                type = NavType.StringType
                                nullable = true
                                defaultValue = null
                            }
                    )
            ) {
                RouteNavigationPage(routeNavigation)
            }
            composable(
                    route = SettingsInteraction.ROUTE_PATTERN,
                    arguments = listOf(
                            navArgument(ARG_RETURN_FROM) {
                                type = NavType.StringType
                                nullable = true
                                defaultValue = null
                            }
                    )
            ) {
                SettingsPage(setting)
            }
            composable(
                    route = SearchSettingInteraction.ROUTE_PATTERN,
                    arguments = listOf(
                            navArgument(ARG_RETURN_FROM) {
                                type = NavType.StringType
                                nullable = true
                                defaultValue = null
                            }
                    )
            ) {
                SearchSettingPage(searchDestinationFilter)
            }
            composable(
                    route = DeveloperSettingInteraction.ROUTE_PATTERN,
                    arguments = listOf(
                            navArgument(ARG_RETURN_FROM) {
                                type = NavType.StringType
                                nullable = true
                                defaultValue = null
                            }
                    )
            ) {
                DeveloperSettingPage(developerSetting)
            }
            composable(
                    route = AboutAppInteraction.ROUTE_PATTERN,
                    arguments = listOf(
                            navArgument(ARG_RETURN_FROM) {
                                type = NavType.StringType
                                nullable = true
                                defaultValue = null
                            }
                    )
            ) {
                AboutAppPage(aboutAppInteraction)
            }
        }
    }
}
