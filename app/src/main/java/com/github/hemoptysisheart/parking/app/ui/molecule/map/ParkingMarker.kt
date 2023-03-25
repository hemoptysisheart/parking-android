package com.github.hemoptysisheart.parking.app.ui.molecule.map

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.support.bitmapDescriptor
import com.github.hemoptysisheart.parking.core.extension.latLng
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun ParkingMarker(context: Context, parking: Location, focused: Boolean) {
    if (focused) {
        Marker(
            state = rememberMarkerState(key = parking.id, position = parking.latLng),
            title = parking.name,
            icon = bitmapDescriptor(context, R.drawable.map_marker_parking_focused),
            zIndex = 9f
        )
    } else {
        Marker(
            state = rememberMarkerState(key = parking.id, position = parking.latLng),
            title = parking.name,
            icon = bitmapDescriptor(context, R.drawable.map_marker_parking),
            zIndex = 8f
        )
    }
}

@Composable
@Preview
fun Preview_ParkingMarker_FocusedIcon() {
    ParkingTheme {
        Image(
            painterResource(R.drawable.map_marker_parking_focused),
            stringResource(R.string.select_route_parking_marker_focused_description)
        )
    }
}

@Composable
@Preview
fun Preview_ParkingMarker_Icon() {
    ParkingTheme {
        Image(
            painterResource(R.drawable.map_marker_parking),
            stringResource(R.string.select_route_parking_marker_description)
        )
    }
}
