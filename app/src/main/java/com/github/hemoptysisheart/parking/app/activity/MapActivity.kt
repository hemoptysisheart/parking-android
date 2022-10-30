package com.github.hemoptysisheart.parking.app.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.hemoptysisheart.core.model.DummyLocationModel
import com.github.hemoptysisheart.parking.app.ui.config.Constants.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.viewmodel.MapViewModel
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

/**
 * 기본 액티비티.
 *
 * 지도 화면 등.
 */
@AndroidEntryPoint
class MapActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParkingTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MapLayout()
                }
            }
        }
    }
}

@Composable
fun MapLayout(viewModel: MapViewModel = viewModel()) {
    Log.v(TAG_COMPOSE, "#MapLayout args : viewModel=$viewModel")

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(35.583323, 139.540254), 17.0F)
    }
    val uiSettings by remember {
        mutableStateOf(MapUiSettings(indoorLevelPickerEnabled = false, mapToolbarEnabled = false))
    }
    val properties by remember {
        mutableStateOf(MapProperties(isBuildingEnabled = true, isMyLocationEnabled = true, isTrafficEnabled = true))
    }

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
    ) {
    }

    LaunchedEffect(true) {
        while (true) {
            viewModel.test()
            delay(1_000L)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MapLayoutPreview() {
    ParkingTheme {
        MapLayout(MapViewModel(DummyLocationModel))
    }
}
