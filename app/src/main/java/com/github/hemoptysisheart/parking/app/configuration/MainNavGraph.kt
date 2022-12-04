package com.github.hemoptysisheart.parking.app.configuration

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.hemoptysisheart.parking.app.ui.component.map.MapScreen
import com.github.hemoptysisheart.parking.app.ui.navigation.MapScreenNavigator
import com.github.hemoptysisheart.parking.app.ui.navigation.MapScreenNavigator.Companion.ARG_PLACE_ID
import com.github.hemoptysisheart.parking.app.ui.navigation.SearchScreenNavigator
import com.github.hemoptysisheart.parking.app.ui.navigation.SearchScreenNavigator.Companion.ARG_LATITUDE
import com.github.hemoptysisheart.parking.app.ui.navigation.SearchScreenNavigator.Companion.ARG_LONGITUDE
import com.github.hemoptysisheart.parking.app.ui.navigation.SearchScreenNavigator.Companion.ARG_ZOOM
import com.github.hemoptysisheart.parking.app.ui.screen.SearchScreen

@Composable
fun MainNavGraph(navController: NavHostController = rememberNavController()) {
    val map = MapScreenNavigator(navController)
    val search = SearchScreenNavigator(navController)

    NavHost(navController = navController, map.routePattern) {
        composable(
            map.routePattern,
            listOf(
                navArgument(ARG_PLACE_ID) { nullable = true }
            )
        ) {
            MapScreen(
                placeId = map.placeId(it),
                openSearch = { center, zoom -> search.open(center.latitude, center.longitude, zoom) }
            )
        }

        composable(
            search.routePattern,
            arguments = listOf(
                navArgument(ARG_LATITUDE) { nullable = false },
                navArgument(ARG_LONGITUDE) { nullable = false },
                navArgument(ARG_ZOOM) { nullable = false }
            )
        ) {
            SearchScreen(
                latitude = it.arguments!!.getString(ARG_LATITUDE)!!.toDouble(),
                longitude = it.arguments!!.getString(ARG_LONGITUDE)!!.toDouble(),
                zoom = it.arguments!!.getString(ARG_ZOOM)!!.toFloat(),
                resultOnClick = { placeId -> map.open(placeId) }
            )
        }
    }
}