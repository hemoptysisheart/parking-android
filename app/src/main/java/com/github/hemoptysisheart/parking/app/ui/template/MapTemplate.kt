package com.github.hemoptysisheart.parking.app.ui.template

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import com.github.hemoptysisheart.parking.app.configuration.LOGGER_COMPOSE as LOGGER

@Composable
fun MapTemplate(
    center: LatLng? = null,
    onMapClick: (LatLng) -> Unit = {}
) {
    LOGGER.v("#HeaderTemplate args : center=$center")

    val cameraPositionState = rememberCameraPositionState()
    center?.also {
        cameraPositionState.position = CameraPosition.fromLatLngZoom(it, 17f)
    }
    GoogleMap(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(1f),
        cameraPositionState = cameraPositionState,
        properties = MapProperties(isBuildingEnabled = true, isMyLocationEnabled = true),
        uiSettings = MapUiSettings(
            indoorLevelPickerEnabled = false,
            mapToolbarEnabled = false,
            myLocationButtonEnabled = false,
            zoomControlsEnabled = false
        ),
        onMapClick = onMapClick
    )
}

@Composable
@Preview
fun Preview_MapTemplate() {
    ParkingTheme {
        MapTemplate()
    }
}