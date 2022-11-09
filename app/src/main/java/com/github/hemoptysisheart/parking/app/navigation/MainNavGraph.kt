package com.github.hemoptysisheart.parking.app.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.hemoptysisheart.parking.app.navigation.Argument.PLACE_ID
import com.github.hemoptysisheart.parking.app.navigation.Argument.getUUID
import com.github.hemoptysisheart.parking.app.navigation.Destination.SCREEN_MAP
import com.github.hemoptysisheart.parking.app.navigation.Destination.SCREEN_SEARCH
import com.github.hemoptysisheart.parking.app.ui.component.map.MapScreen
import com.github.hemoptysisheart.parking.app.ui.screen.SearchScreen
import com.github.hemoptysisheart.parking.domain.Place
import java.util.*

object Argument {
    /**
     * [Place.id]
     */
    const val PLACE_ID = "placeId"

    private fun String?.toUUID() = if (isNullOrEmpty()) {
        null
    } else {
        UUID.fromString(this)
    }

    fun Bundle?.getUUID(key: String) = this?.getString(key).toUUID()
}

object Destination {
    /**
     * 오타방지용 상수.
     */
    private const val PREFIX_SCREEN = "screen"

    /**
     * [com.github.hemoptysisheart.parking.app.ui.component.map.MapScreen]
     */
    const val SCREEN_MAP = "$PREFIX_SCREEN/map?placeId={$PLACE_ID}"

    /**
     * [com.github.hemoptysisheart.parking.app.ui.screen.SearchScreen]
     */
    const val SCREEN_SEARCH = "$PREFIX_SCREEN/search"
}

@Composable
fun MainNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, SCREEN_MAP) {
        composable(
            SCREEN_MAP,
            listOf(
                navArgument(PLACE_ID) { defaultValue = "" }
            )
        ) {
            MapScreen(
                placeId = it.arguments?.getUUID(PLACE_ID),
                openSearch = {
                    navController.navigate(SCREEN_SEARCH)
                })
        }

        composable(SCREEN_SEARCH) {
            SearchScreen(setPlaceOnMap = {
                navController.navigate(SCREEN_MAP.replace("{${PLACE_ID}}", "$it"))
            })
        }
    }
}