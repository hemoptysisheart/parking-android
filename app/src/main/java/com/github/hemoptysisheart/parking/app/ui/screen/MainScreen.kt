package com.github.hemoptysisheart.parking.app.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.hemoptysisheart.parking.app.ui.component.Map
import com.github.hemoptysisheart.parking.app.ui.component.MapOverlay
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.DEFAULT_ZOOM_LEVEL
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewViewModel.MAIN_VM
import com.github.hemoptysisheart.parking.app.ui.state.MainScreenState
import com.github.hemoptysisheart.parking.app.ui.state.OverlayState
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel.Status.*
import com.github.hemoptysisheart.parking.app.viewmodel.toLatLng
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.rememberCameraPositionState

/**
 * 메인 화면 UI.
 */
@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val state = remember { MainScreenState() }

    val status by viewModel.status.collectAsStateWithLifecycle()
    val here by viewModel.here.collectAsStateWithLifecycle()
    Log.v(TAG_COMPOSE, "#MainScreen : status=$status, here=$here")

    val cameraPositionState = rememberCameraPositionState()
    when (status) {
        INIT -> {}
        LOCATION_READY -> {
            cameraPositionState.position = CameraPosition.fromLatLngZoom(here.toLatLng(), DEFAULT_ZOOM_LEVEL)
            viewModel.ready()
        }
        UI_LINKED -> {
            viewModel.center = cameraPositionState.position.target
            viewModel.zoom = cameraPositionState.position.zoom
        }
    }

    // ----------------------------------------------------------------------------------------------------------------

    Box(modifier = Modifier.fillMaxSize()) {
        if (OverlayState.HIDE != state.overlayState) {
            MapOverlay(state)
        }
        Map(cameraPositionState)
    }
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
