package com.github.hemoptysisheart.parking.app.ui.navigation

import androidx.navigation.NavHostController

class SearchScreenNavigator(navController: NavHostController) : Nav(navController) {
    companion object {
        private val TAG = SearchScreenNavigator::class.simpleName

        const val SCREEN_SEARCH = "$ROUTE_PREFIX_SCREEN/search"

        const val ARG_LATITUDE = "latitude"
        const val ARG_LONGITUDE = "longitude"
        const val ARG_ZOOM = "zoom"
    }

    override val routePath = SCREEN_SEARCH

    override val routePattern = buildRoutePattern(routePath, ARG_LATITUDE, ARG_LONGITUDE, ARG_ZOOM)

    override val argNames = setOf(ARG_LATITUDE, ARG_LONGITUDE, ARG_ZOOM)

    /**
     * 좌표를 중심으로 검색하기.
     */
    fun open(latitude: Double, longitude: Double, zoom: Float) = open(
        buildRoute(
            ARG_LATITUDE to latitude,
            ARG_LONGITUDE to longitude,
            ARG_ZOOM to zoom
        )
    ) {}
}
