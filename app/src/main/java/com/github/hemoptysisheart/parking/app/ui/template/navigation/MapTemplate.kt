package com.github.hemoptysisheart.parking.app.ui.template.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.molecule.map.DestinationMarker
import com.github.hemoptysisheart.parking.app.ui.molecule.map.ParkingMarker
import com.github.hemoptysisheart.parking.app.ui.molecule.map.RouteOverview
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRoute
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.core.extension.latLng
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Route
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_COMPOSE as LOGGER

@Composable
fun MapTemplate(
    here: GeoLocation,
    route: Route
) {
    LOGGER.v("#MapTemplate args : here=$here, route=$route")

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(here.latLng, 17f)
    }

    Column(Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            cameraPositionState = cameraPositionState,
            properties = MapProperties(isBuildingEnabled = true, isMyLocationEnabled = true),
            uiSettings = MapUiSettings(
                indoorLevelPickerEnabled = false,
                mapToolbarEnabled = false,
                myLocationButtonEnabled = false,
                zoomControlsEnabled = false
            )
        ) {
            DestinationMarker(context = LocalContext.current, destination = route.destination)
            ParkingMarker(context = LocalContext.current, route = route, focused = true)
            RouteOverview(driving = route.driving, walking = route.walking, focused = true)
        }

        NavigationDetailTemplate(here, route, Modifier.weight(1f))
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_MapTemplate() {
    ParkingTheme {
        MapTemplate(PreviewLocation.LOCATION_신주쿠역, PreviewRoute.ROUTE_新宿駅_패밀리마트_카부키쵸키타점)
    }
}
