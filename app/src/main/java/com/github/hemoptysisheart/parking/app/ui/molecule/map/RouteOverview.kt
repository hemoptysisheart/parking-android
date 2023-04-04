package com.github.hemoptysisheart.parking.app.ui.molecule.map

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.github.hemoptysisheart.parking.app.ui.support.MAP_ROUTE_OVERVIEW_DRIVING_FOCUSED_Z_INDEX
import com.github.hemoptysisheart.parking.app.ui.support.MAP_ROUTE_OVERVIEW_DRIVING_Z_INDEX
import com.github.hemoptysisheart.parking.app.ui.support.MAP_ROUTE_OVERVIEW_WALKING_FOCUSED_Z_INDEX
import com.github.hemoptysisheart.parking.app.ui.support.MAP_ROUTE_OVERVIEW_WALKING_Z_INDEX
import com.github.hemoptysisheart.parking.app.ui.theme.LightSkyBlue
import com.github.hemoptysisheart.parking.core.extension.latLng
import com.github.hemoptysisheart.parking.core.model.dto.RouteImpl
import com.github.hemoptysisheart.parking.domain.Route
import com.google.maps.android.compose.Polyline

@Composable
fun RouteOverview(route: Route, focused: Boolean) {
    if (route is RouteImpl && route.initialized) {
        if (focused) {
            Polyline(
                points = route.driving.overview.map { it.latLng },
                color = Color.Blue,
                width = 15f,
                zIndex = MAP_ROUTE_OVERVIEW_DRIVING_FOCUSED_Z_INDEX
            )
            Polyline(
                points = route.walking.overview.map { it.latLng },
                color = Color.Gray,
                width = 15f,
                zIndex = MAP_ROUTE_OVERVIEW_WALKING_FOCUSED_Z_INDEX
            )
        } else {
            Polyline(
                points = route.driving.overview.map { it.latLng },
                color = LightSkyBlue,
                zIndex = MAP_ROUTE_OVERVIEW_DRIVING_Z_INDEX
            )
            Polyline(
                points = route.walking.overview.map { it.latLng },
                color = Color.LightGray,
                zIndex = MAP_ROUTE_OVERVIEW_WALKING_Z_INDEX
            )
        }
    }
}
