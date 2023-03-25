package com.github.hemoptysisheart.parking.app.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.navigation.SelectRoutePageNavigation
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewViewModel.SELECT_ROUTE_VM
import com.github.hemoptysisheart.parking.app.ui.template.SelectRouteHeader
import com.github.hemoptysisheart.parking.app.viewmodel.SelectRouteViewModel
import com.github.hemoptysisheart.parking.core.extension.latLng
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun SelectRoutePage(
    navigation: SelectRoutePageNavigation = SelectRoutePageNavigation(rememberNavController()),
    viewModel: SelectRouteViewModel = hiltViewModel()
) {
    var showControl by rememberSaveable {
        mutableStateOf(true)
    }
    val destination by viewModel.destination.collectAsStateWithLifecycle()
    val cameraPositionState = rememberCameraPositionState()
    cameraPositionState.position = CameraPosition.fromLatLngZoom(destination.latLng, 15f)

    Box(modifier = Modifier.fillMaxSize()) {
        if (showControl) {
            SelectRouteHeader(destination = destination, navigation.onBack)
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
            onMapClick = {
                showControl = !showControl
            }
        )
    }
}

@Composable
@Preview
fun Preview_SelectRoutePage() {
    ParkingTheme {
        SelectRoutePage(viewModel = SELECT_ROUTE_VM)
    }
}
