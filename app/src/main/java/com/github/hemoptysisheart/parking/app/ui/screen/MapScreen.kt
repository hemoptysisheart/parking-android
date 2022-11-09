package com.github.hemoptysisheart.parking.app.ui.component.map

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.hemoptysisheart.parking.app.ui.configuration.LogicConstant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.viewmodel.MapViewModel
import com.github.hemoptysisheart.parking.core.dummy.model.DummyLocationModel
import com.github.hemoptysisheart.parking.core.dummy.model.DummyPlaceModel
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import java.util.*

@Composable
fun MapScreen(
    placeId: UUID? = null,
    viewModel: MapViewModel = hiltViewModel(),
    openSearch: () -> Unit = {}
) {
    Log.v(TAG_COMPOSE, "#MapView args : placeId=$placeId, viewModel=$viewModel, openSearch=$openSearch")

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
        MapHeader(null, openSearch)
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
        MapScreen(viewModel = MapViewModel(DummyLocationModel, DummyPlaceModel))
    }
}