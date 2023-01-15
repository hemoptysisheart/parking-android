package com.github.hemoptysisheart.parking.app.ui.navigation

import android.util.Log
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import java.util.*

abstract class Nav(
    private val navController: NavHostController
) {
    companion object {
        private const val TAG = "Navigation"

        /**
         * 화면 단위 `@Composable`의 경로 접두어.
         */
        const val ROUTE_PREFIX_SCREEN = "screen"
    }

    abstract val routePath: String

    /**
     * 루트의 패턴.
     */
    abstract val routePattern: String

    /**
     * 사용 가능한 인자의 목록.
     */
    abstract val argNames: Set<String>

    internal fun String?.toUUID() = if (isNullOrEmpty()) {
        null
    } else {
        UUID.fromString(this)
    }

    internal fun buildRoutePattern(path: String, vararg args: String) = args.joinToString("&", "$path?") {
        "$it={$it}"
    }

    internal fun buildRoute(vararg args: Pair<String, Any?>): String {
        val route = args.filter { argNames.contains(it.first) }
            .joinToString("&", "$routePath?") { "${it.first}=${it.second}" }

        Log.d(TAG, "#route return : $route")
        return route
    }

    internal fun open(route: String, options: NavOptionsBuilder.() -> Unit = {}) {
        Log.v(TAG, "#open args : route=$route, options=$options")
        navController.navigate(route, options)
    }
}
