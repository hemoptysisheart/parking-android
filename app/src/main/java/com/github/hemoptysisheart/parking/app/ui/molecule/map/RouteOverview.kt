package com.github.hemoptysisheart.parking.app.ui.molecule.map

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.github.hemoptysisheart.parking.app.domain.RouteImpl
import com.github.hemoptysisheart.parking.core.extension.points
import com.github.hemoptysisheart.parking.domain.Route
import com.github.hemoptysisheart.parking.ui.theme.LightSkyBlue
import com.google.maps.android.compose.Polyline

@Composable
fun RouteOverview(route: Route, focused: Boolean) {
    if (route is RouteImpl && route.initialized) {
        if (focused) {
            Polyline(points = route.driving.overview.points, color = Color.Blue, width = 15f, zIndex = 1f)
            Polyline(points = route.walking.overview.points, color = Color.Gray, width = 15f, zIndex = 1f)
        } else {
            Polyline(points = route.driving.overview.points, color = LightSkyBlue)
            Polyline(points = route.walking.overview.points, color = Color.LightGray)
        }
    }
}
