package com.github.hemoptysisheart.parking.app.ui.molecule.map

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.support.*
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.core.extension.latLng
import com.github.hemoptysisheart.parking.domain.Route
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun ParkingMarker(
    context: Context,
    route: Route,
    focused: Boolean,
    onSelect: (Route) -> Unit = { LOGGER.v("#onSelect args : route=$it") }
) {
    LOGGER.v("#ParkingMarker args : context=$context, route=$route, focused=$focused, onSelect=$onSelect")
    if (focused) {
        Marker(
            state = rememberMarkerState(key = route.parking.id, position = route.parking.latLng),
            alpha = MAP_MARKER_FOCUSED_ALPHA,
            icon = bitmapDescriptor(context, R.drawable.map_marker_parking_focused),
            tag = route,
            title = route.parking.name,
            zIndex = MAP_MARKER_FOCUSED_Z_INDEX
        )
    } else {
        Marker(
            state = rememberMarkerState(key = route.parking.id, position = route.parking.latLng),
            alpha = MAP_MARKER_ALPHA,
            icon = bitmapDescriptor(context, R.drawable.map_marker_parking),
            tag = route,
            title = route.parking.name,
            zIndex = MAP_MARKER_Z_INDEX,
            onClick = {
                onSelect(it.tag as Route)
                false
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_ParkingMarker_FocusedIcon() {
    ParkingTheme {
        Image(
            painter = painterResource(R.drawable.map_marker_parking_focused),
            contentDescription = stringResource(R.string.select_route_parking_marker_focused_description),
            alpha = MAP_MARKER_FOCUSED_ALPHA
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_ParkingMarker_Icon() {
    ParkingTheme {
        Image(
            painter = painterResource(R.drawable.map_marker_parking),
            contentDescription = stringResource(R.string.select_route_parking_marker_description),
            alpha = MAP_MARKER_ALPHA
        )
    }
}
