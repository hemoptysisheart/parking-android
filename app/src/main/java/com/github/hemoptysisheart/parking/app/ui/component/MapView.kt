package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.maps.android.compose.*

/**
 * 기본 지도 출력하기.
 *
 * @param cameraPositionState 지도 카메라 위치.
 */
@Composable
fun MapView(
    cameraPositionState: CameraPositionState
) {
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

@Composable
@Preview(showBackground = true)
@SuppressLint("ComposableNaming")
fun preview_MapView() {
    ParkingTheme {
        MapView(rememberCameraPositionState())
    }
}
