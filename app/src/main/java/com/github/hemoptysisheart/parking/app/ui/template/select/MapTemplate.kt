package com.github.hemoptysisheart.parking.app.ui.template.select

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.github.hemoptysisheart.parking.app.ui.molecule.map.DestinationMarker
import com.github.hemoptysisheart.parking.app.ui.molecule.map.ParkingMarker
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation
import com.github.hemoptysisheart.parking.core.extension.latLng
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItemLocation
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapTemplate(
    destination: Location,
    parkingList: List<RecommendItemLocation>,
    onClick: (LatLng) -> Unit = {}
) {
    val context = LocalContext.current
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(destination.latLng, 15f)
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
        onMapClick = onClick
    ) {
        DestinationMarker(context, destination)
        parkingList.forEachIndexed { index, item ->
            ParkingMarker(context, item.item, 0 == index)
        }
    }
}

@Composable
@Preview
fun Preview_MapTemplate() {
    ParkingTheme {
        MapTemplate(PreviewLocation.LOCATION_株式会社ＡＡＡ, listOf())
    }
}
