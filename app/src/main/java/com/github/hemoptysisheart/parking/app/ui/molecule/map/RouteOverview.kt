package com.github.hemoptysisheart.parking.app.ui.molecule.map

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.github.hemoptysisheart.parking.app.ui.support.MAP_ROUTE_OVERVIEW_DRIVING_FOCUSED_Z_INDEX
import com.github.hemoptysisheart.parking.app.ui.support.MAP_ROUTE_OVERVIEW_DRIVING_Z_INDEX
import com.github.hemoptysisheart.parking.app.ui.support.MAP_ROUTE_OVERVIEW_WALKING_FOCUSED_Z_INDEX
import com.github.hemoptysisheart.parking.app.ui.support.MAP_ROUTE_OVERVIEW_WALKING_Z_INDEX
import com.github.hemoptysisheart.parking.app.ui.theme.LightSkyBlue
import com.github.hemoptysisheart.parking.core.extension.latLng
import com.github.hemoptysisheart.parking.domain.PartialRoute
import com.github.hemoptysisheart.parking.domain.Route
import com.google.maps.android.compose.Polyline
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_COMPOSE as LOGGER

@Composable
fun RouteOverview(driving:PartialRoute?, walking:PartialRoute?, focused: Boolean) {
    LOGGER.v("#RouteOverview args : driving=$driving, walking=$walking, focused=$focused")

    if (focused) {
        driving?.run {
            Polyline(
                points = overview.map { it.latLng },
                color = Color.Blue,
                width = 15f,
                zIndex = MAP_ROUTE_OVERVIEW_DRIVING_FOCUSED_Z_INDEX
            )
        }
        walking?.run {
            Polyline(
                points = overview.map { it.latLng },
                color = Color.Gray,
                width = 15f,
                zIndex = MAP_ROUTE_OVERVIEW_WALKING_FOCUSED_Z_INDEX
            )
        }
    } else {
        driving?.run {
            Polyline(
                points = overview.map { it.latLng },
                color = LightSkyBlue,
                zIndex = MAP_ROUTE_OVERVIEW_DRIVING_Z_INDEX
            )
        }
        walking?.run {
            Polyline(
                points = overview.map { it.latLng },
                color = Color.LightGray,
                zIndex = MAP_ROUTE_OVERVIEW_WALKING_Z_INDEX
            )
        }
    }
}

@Composable
fun RouteOverview(route: Route, focused: Boolean) {
    RouteOverview(driving = route.driving, walking = route.walking, focused = focused)
}

