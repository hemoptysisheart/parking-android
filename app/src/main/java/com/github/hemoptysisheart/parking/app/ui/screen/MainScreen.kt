package com.github.hemoptysisheart.parking.app.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewViewModel.MAIN_VM
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val here by viewModel.here.collectAsState()
    val center by viewModel.center.collectAsState()
    val zoom by viewModel.zoom.collectAsState()
    Log.v(TAG_COMPOSE, "#MainScreen : here=$here, center=$center, zoom=$zoom")

    val cameraPositionState = rememberCameraPositionState()
    center?.let {
        cameraPositionState.position = CameraPosition.fromLatLngZoom(it, zoom)
    }
    val uiSettings by remember {
        mutableStateOf(
            MapUiSettings(
                indoorLevelPickerEnabled = false,
                mapToolbarEnabled = false,
                myLocationButtonEnabled = false,
                zoomControlsEnabled = false
            )
        )
    }
    val properties by remember {
        mutableStateOf(MapProperties(isBuildingEnabled = true, isMyLocationEnabled = true, isTrafficEnabled = true))
    }

    GoogleMap(
        modifier = Modifier
            .fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings
    )
}

@SuppressLint("ComposableNaming")
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun preview_MainScreen() {
    ParkingTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            MainScreen(MAIN_VM)
        }
    }
}
