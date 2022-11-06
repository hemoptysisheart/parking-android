package com.github.hemoptysisheart.parking.app.ui.component.map

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.hemoptysisheart.parking.app.ui.configuration.LogicConstant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.viewmodel.MapViewModel
import com.github.hemoptysisheart.parking.core.model.DummyLocationModel
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(viewModel: MapViewModel = hiltViewModel()) {
    Log.v(TAG_COMPOSE, "#MapView args : viewModel=$viewModel")

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(35.583323, 139.540254), 17.0F)
    }
    val uiSettings by remember {
        mutableStateOf(MapUiSettings(indoorLevelPickerEnabled = false, mapToolbarEnabled = false))
    }
    val properties by remember {
        mutableStateOf(MapProperties(isBuildingEnabled = true, isMyLocationEnabled = true, isTrafficEnabled = true))
    }

    Column(modifier = Modifier.fillMaxSize()) {
        MapHeader(null)
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = properties,
            uiSettings = uiSettings,
            onMapLongClick = {
                Log.v(TAG_COMPOSE, "#map.onMapLongClick args : latlng=$it")
            },
            onMyLocationButtonClick = {
                Log.v(TAG_COMPOSE, "#map.onMyLocationButtonClick called.")
                false
            }
        )
    }
}

@Composable
@Preview
fun MapScreenPreview() {
    ParkingTheme {
        MapScreen(MapViewModel(DummyLocationModel))
    }
}