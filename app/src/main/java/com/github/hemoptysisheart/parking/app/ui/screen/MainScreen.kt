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
import com.github.hemoptysisheart.parking.app.ui.component.MapView
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewViewModel.MAIN_VM
import com.github.hemoptysisheart.parking.app.ui.state.MainScreenState
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.LatLng

/**
 * 메인 화면 UI.
 */
@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val state = remember {
        MainScreenState()
    }
    val here by viewModel.here.collectAsState()
    val locationPrepared by viewModel.locationPrepared.collectAsState()
    Log.v(TAG_COMPOSE, "#MainScreen : here=$here, locationPrepared=$locationPrepared")

    if (state.extendOverlay) {
        // TODO 열린 오버레이 표시.
    } else {
        // TODO 접힌 오버레이(헤더) 표시.

        if (locationPrepared) {
            Log.i(TAG_COMPOSE, "#MainScreen location prepared.")
            MapView(LatLng(here.latitude, here.longitude), MainViewModel.DEFAULT_ZOOM_LEVEL) { center, zoom ->
                Log.v(TAG_COMPOSE, "#mapObserver args : center=$center, zoom=$zoom")
                viewModel.center = center
                viewModel.zoom = zoom
            }
        } else {
            Log.w(TAG_COMPOSE, "#MainScreen location not prepared.")
            MapView()
        }
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
