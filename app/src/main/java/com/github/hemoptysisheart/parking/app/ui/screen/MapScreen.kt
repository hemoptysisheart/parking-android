package com.github.hemoptysisheart.parking.app.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.hemoptysisheart.parking.app.ui.component.map.MapHeader
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

/**
 * [MapScreen](https://www.figma.com/file/I3LN6lcAVaAXlNba0kBKPN/Parking?node-id=112%3A508&t=TzUdFxNeMKN4ZpTv-4)
 */
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

    val location by viewModel.location.collectAsState()
    val zoom by viewModel.zoom.collectAsState()
    val destination by viewModel.destination.collectAsState()

    val cameraPositionState = rememberCameraPositionState {
        Log.v(TAG_COMPOSE, "#MapScreen.cameraPositionState : location=$location")
        position = CameraPosition.fromLatLngZoom(
            LatLng(location.latitude.toDouble(), location.longitude.toDouble()),
            zoom
        )
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
            onMapClick = {
                Log.v(TAG_COMPOSE, "#GoogleMap.onMapClick args : latlng=$it")
            },
            onMapLongClick = {
                Log.v(TAG_COMPOSE, "#GoogleMap.onMapLongClick args : latlng=$it")
            },
            onMapLoaded = {
                Log.v(TAG_COMPOSE, "#GoogleMap.onMapLoaded called.")
            },
            onMyLocationButtonClick = {
                Log.v(TAG_COMPOSE, "#GoogleMap.onMyLocationButtonClick called.")
                false
            },
            onMyLocationClick = {
                Log.v(TAG_COMPOSE, "#GoogleMap.onMyLocationClick args : location=$it")
            },
            onPOIClick = {
                Log.v(TAG_COMPOSE, "#GoogleMap.onPOIClick args : pointOfInterest=$it")
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MapScreenPreviewInit() {
    ParkingTheme {
        MapScreen(viewModel = MapViewModel(DummyPlaceModel, DummyLocationModel))
    }
}

@Composable
@Preview(showBackground = true)
fun MapScreenPreviewSearch() {
    ParkingTheme {
        MapScreen(
            placeId = DummyPlace.PLACE1.id,
            viewModel = MapViewModel(DummyPlaceModel, DummyLocationModel)
        )
    }
}