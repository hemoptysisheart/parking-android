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
import com.github.hemoptysisheart.parking.core.dummy.domain.DummyPlace
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

    if (null != placeId) {
        viewModel.loadPlace(placeId)
    }

    val destination by viewModel.destination.collectAsState()

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
        MapHeader(destination, openSearch)
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
@Preview(showBackground = true)
fun MapScreenPreviewInit() {
    ParkingTheme {
        MapScreen(viewModel = MapViewModel(DummyLocationModel, DummyPlaceModel))
    }
}

@Composable
@Preview(showBackground = true)
fun MapScreenPreviewSearch() {
    ParkingTheme {
        MapScreen(
            placeId = DummyPlace.PLACE1.id,
            viewModel = MapViewModel(DummyLocationModel, DummyPlaceModel)
        )
    }
}