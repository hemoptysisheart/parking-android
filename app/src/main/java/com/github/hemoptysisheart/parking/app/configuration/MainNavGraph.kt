package com.github.hemoptysisheart.parking.app.navigation

import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.hemoptysisheart.parking.app.navigation.Argument.LATITUDE
import com.github.hemoptysisheart.parking.app.navigation.Argument.LONGITUDE
import com.github.hemoptysisheart.parking.app.navigation.Argument.PLACE_ID
import com.github.hemoptysisheart.parking.app.navigation.Argument.ZOOM
import com.github.hemoptysisheart.parking.app.navigation.Argument.getUUID
import com.github.hemoptysisheart.parking.app.navigation.Destination.SCREEN_MAP
import com.github.hemoptysisheart.parking.app.navigation.Destination.SCREEN_SEARCH
import com.github.hemoptysisheart.parking.app.navigation.Destination.route
import com.github.hemoptysisheart.parking.app.ui.component.map.MapScreen
import com.github.hemoptysisheart.parking.app.ui.configuration.UiConstants.TAG_NAVIGATION
import com.github.hemoptysisheart.parking.app.ui.screen.SearchScreen
import com.github.hemoptysisheart.parking.domain.Place
import java.util.*

object Argument {
    /**
     * @see [Place.id]
     * @see [Argument.toUUID]
     */
    const val PLACE_ID = "placeId"

    /**
     * 위도
     * - 타입 : [Double]
     */
    const val LATITUDE = "latitude"

    /**
     * 경도
     * - 타입 : [Double]
     */
    const val LONGITUDE = "longitude"

    /**
     * 줌 레벨.
     * - 타입 : [Double]
     */
    const val ZOOM = "zoom"

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
     * [com.github.hemoptysisheart.parking.app.ui.component.map.MapScreen]의 루트 패턴.
     */
    const val SCREEN_MAP = "$PREFIX_SCREEN/map?$PLACE_ID={$PLACE_ID}"

    /**
     * [com.github.hemoptysisheart.parking.app.ui.screen.SearchScreen]의 루트 패턴.
     */
    const val SCREEN_SEARCH = "$PREFIX_SCREEN/search?$LATITUDE={$LATITUDE}&$LONGITUDE={$LONGITUDE}&$ZOOM={$ZOOM}"

    /**
     * 네비게이션 루트를 만든다.
     *
     * @param routePattern 루트 패턴.
     * @param arguments 루트 인자. [Pair.first]는 인자 이름, [Pair.second]는 인자 값.
     */
    internal fun String.route(vararg arguments: Pair<String, Any?>): String {
        var route = this
        for (arg in arguments) {
            route = route.replace("{${arg.first}}", "${arg.second}")
        }
        Log.v(TAG_NAVIGATION, "#route return : $route")
        return route
    }
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
                openSearch = { center, zoom ->
                    Log.d(TAG_NAVIGATION, "#openSearch args : center=$center, zoom=$zoom")
                    navController.navigate(
                        SCREEN_SEARCH.route(
                            LATITUDE to center.latitude,
                            LONGITUDE to center.longitude,
                            ZOOM to zoom
                        )
                    )
                }
            )
        }

        composable(
            SCREEN_SEARCH,
            arguments = listOf(
                navArgument(LATITUDE) { nullable = false },
                navArgument(LONGITUDE) { nullable = false },
                navArgument(ZOOM) { nullable = false }
            )
        ) {
            SearchScreen(
                latitude = it.arguments!!.getString(LATITUDE)!!.toDouble(),
                longitude = it.arguments!!.getString(LONGITUDE)!!.toDouble(),
                zoom = it.arguments!!.getString(ZOOM)!!.toFloat(),
                resultOnClick = { placeId ->
                    Log.d(TAG_NAVIGATION, "#resultOnClick args : placeId=$placeId")
                    navController.navigate(SCREEN_MAP.route(PLACE_ID to placeId)) {
                        popUpTo(SCREEN_MAP) { inclusive = true }
                    }
                }
            )
        }
    }
}