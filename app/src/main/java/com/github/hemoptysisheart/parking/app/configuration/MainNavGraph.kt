package com.github.hemoptysisheart.parking.app.configuration

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.hemoptysisheart.parking.app.ui.component.map.MapScreen
import com.github.hemoptysisheart.parking.app.ui.navigation.MapScreenNavigator
import com.github.hemoptysisheart.parking.app.ui.navigation.MapScreenNavigator.Companion.SCREEN_MAP
import com.github.hemoptysisheart.parking.app.ui.navigation.SearchScreenNavigator
import com.github.hemoptysisheart.parking.app.ui.navigation.SearchScreenNavigator.Companion.SCREEN_SEARCH
import com.github.hemoptysisheart.parking.app.ui.screen.SearchScreen

@Composable
fun MainNavGraph(navController: NavHostController = rememberNavController()) {
    val map = MapScreenNavigator(navController)
    val search = SearchScreenNavigator(navController)

    NavHost(navController = navController, SCREEN_MAP) {
        composable(
            SCREEN_MAP,
            listOf(
                navArgument(MapScreenNavigator.ARG_PLACE_ID) { nullable = true }
            )
        ) {
            MapScreen(
                placeId = map.placeId(it),
                openSearch = { center, zoom -> search.open(center.latitude, center.longitude, zoom) }
            )
        }

        composable(
            SCREEN_SEARCH,
            arguments = listOf(
                navArgument(SearchScreenNavigator.ARG_LATITUDE) { nullable = false },
                navArgument(SearchScreenNavigator.ARG_LONGITUDE) { nullable = false },
                navArgument(SearchScreenNavigator.ARG_ZOOM) { nullable = false }
            )
        ) {
            SearchScreen(
                latitude = it.arguments!!.getString(SearchScreenNavigator.ARG_LATITUDE)!!.toDouble(),
                longitude = it.arguments!!.getString(SearchScreenNavigator.ARG_LONGITUDE)!!.toDouble(),
                zoom = it.arguments!!.getString(SearchScreenNavigator.ARG_ZOOM)!!.toFloat(),
                resultOnClick = { placeId -> map.open(placeId) }
            )
        }
    }
}