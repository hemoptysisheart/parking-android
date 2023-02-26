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
import com.github.hemoptysisheart.parking.app.ui.component.MapOverlayCollapse
import com.github.hemoptysisheart.parking.app.ui.component.MapOverlayExtend
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewViewModel.MAIN_VM
import com.github.hemoptysisheart.parking.app.ui.state.OverlayState.*
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel.MapControl.GOTO_DESTINATION
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel.MapControl.GOTO_HERE
import com.github.hemoptysisheart.parking.app.viewmodel.toLatLng
import com.github.hemoptysisheart.parking.core.logging.logArgs
import com.github.hemoptysisheart.parking.core.logging.logVarsV
import com.github.hemoptysisheart.parking.core.model.dto.toLatLng
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.rememberCameraPositionState

/**
 * 메인 화면 UI.
 *
 * 1. 주요 레이아웃 정리.
 * 2. UI 상태 호이스팅.
 */
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    logArgs(TAG_COMPOSE, "MainScreen", "viewModel" to viewModel)

    val overlay by viewModel.overlay.collectAsStateWithLifecycle()
    val here by viewModel.here.collectAsStateWithLifecycle()
    val destination by viewModel.destination.collectAsStateWithLifecycle()
    val destinationQuery by viewModel.destinationQuery.collectAsStateWithLifecycle()
    val searchDestinationResult by viewModel.destinationSearchResult.collectAsStateWithLifecycle()
    val parkingList by viewModel.parkingList.collectAsStateWithLifecycle()
    val routeList by viewModel.routeList.collectAsStateWithLifecycle()

    logVarsV(
        TAG_COMPOSE,
        "MainScreen",
        "overlay" to overlay,
        "here" to here,
        "destination" to destination,
        "destinationQuery" to destinationQuery,
        "searchDestinationResult" to searchDestinationResult,
        "parkingList" to parkingList,
        "routeList" to routeList
    )

    val mapControl by viewModel.mapControl.collectAsStateWithLifecycle()
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(0.0, 0.0), MainViewModel.DEFAULT_ZOOM_LEVEL)
    }

    mapControl?.let {
        @Suppress("REDUNDANT_ELSE_IN_WHEN")
        when (it) {
            GOTO_HERE ->
                cameraPositionState.position = CameraPosition.fromLatLngZoom(here!!.toLatLng(), viewModel.zoom)
            GOTO_DESTINATION ->
                cameraPositionState.position = CameraPosition.fromLatLngZoom(destination!!.toLatLng(), viewModel.zoom)
            else ->
                Log.e(TAG_COMPOSE, "#MainScreen unsupported map control : mapControl=$mapControl")
        }
        viewModel.done(it)
    }
    viewModel.center = cameraPositionState.position.target
    viewModel.zoom = cameraPositionState.position.zoom

    // ----------------------------------------------------------------------------------------------------------------

    Box(modifier = Modifier.fillMaxSize()) {
        when (overlay) {
            COLLAPSE ->
                MapOverlayCollapse(destination = destination, onExtend = { viewModel.onExtendOverlay() })
            EXTEND ->
                MapOverlayExtend(
                    destinationQuery = destinationQuery,
                    searchDestinationResult = searchDestinationResult,
                    distanceCalculator = {
                        Log.d(TAG_COMPOSE, "#distanceCalculator args : location=$it")
                        here?.run {
                            val result = FloatArray(3)
                            android.location.Location.distanceBetween(
                                latitude, longitude, it.latitude, it.longitude, result
                            )
                            result[0].toDouble()
                        } ?: 0.0
                    },
                    onDestinationQueryChange = { viewModel.searchDestination(it) },
                    onSelectRecommend = {
                        it.item.let { item ->
                            when (item) {
                                is Location ->
                                    viewModel.setDestination(item)
                                else ->
                                    Log.e(TAG_COMPOSE, "#MainScreen unsupported item type : recommended=$it")
                            }
                        }
                    },
                    onCollapse = { viewModel.onCollapseOverlay() }
                )
            else -> {}
        }

        Map(
            destination = destination,
            parkingList = parkingList,
            routeList = routeList,
            cameraPositionState = cameraPositionState
        ) {
            when (overlay) {
                HIDE ->
                    viewModel.onShowOverlay()
                COLLAPSE ->
                    viewModel.onHideOverlay()
                else ->
                    Log.e(TAG_COMPOSE, "#onMapClick illegal overlay state : overlay=$overlay")
            }
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
