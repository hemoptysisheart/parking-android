package com.github.hemoptysisheart.parking.app.ui.molecule.map

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.support.bitmapDescriptor
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.core.extension.latLng
import com.github.hemoptysisheart.parking.domain.Location
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun DestinationMarker(context: Context, destination: Location) {
    Marker(
        state = rememberMarkerState(destination.id, destination.latLng),
        icon = bitmapDescriptor(context, R.drawable.map_marker_destination),
        zIndex = 10f
    )
}

@Composable
@Preview
fun Preview_DestinationMarker_Icon() {
    ParkingTheme {
        Image(
            painterResource(id = R.drawable.map_marker_destination),
            stringResource(id = R.string.select_route_destination_marker_description)
        )
    }
}
