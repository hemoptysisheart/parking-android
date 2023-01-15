package com.github.hemoptysisheart.parking.app.ui.navigation

import android.util.Log
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.github.hemoptysisheart.parking.domain.Place1
import java.util.*

/**
 * TODO `com.github.hemoptysisheart.parking.app.ui.component.map.MapScreenKt.MapScreen` 열기용으로 변경.
 */
class MapScreenNavigator(navController: NavHostController) : Nav(navController) {
    companion object {
        private val TAG = MapScreenNavigator::class.simpleName

        /**
         * `MapScreen`의 루트 패턴.
         */
        const val SCREEN_MAP = "$ROUTE_PREFIX_SCREEN/map"

        const val ARG_PLACE_ID = "placeId"

    }

    override val routePath = SCREEN_MAP

    override val routePattern = buildRoutePattern(routePath, ARG_PLACE_ID)

    override val argNames = setOf(ARG_PLACE_ID)

    fun placeId(entry: NavBackStackEntry) = entry.arguments?.getString(ARG_PLACE_ID).toUUID()

    /**
     * 장소의 위치를 중심으로 지도 열기.
     *
     * @param place [Place1.id]
     */
    fun open(place: UUID? = null) = open(buildRoute(ARG_PLACE_ID to place)) {
        popUpTo(SCREEN_MAP)
    }

    /**
     * `SearchScreen`으로 이동.
     */
    @Deprecated("도착지 우선으로 변경.")
    fun navigateToSearch() {
        Log.v(TAG, "#navigateToSearch called.")
    }
}
