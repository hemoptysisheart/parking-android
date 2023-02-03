package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

/**
 * 기본 지도 출력하기.
 *
 * @param initCenter 지도를 처음 표시할 때 사용할 위치.
 * @param initZoom 지도의 기본 확대 수준.
 * @param mapObserver 지도 옵저버. 지도 정보가 바뀔 때 필요한 처리를 한다.
 */
@Composable
fun MapView(
    initCenter: LatLng? = null, initZoom: Float? = null,
    mapObserver: (center: LatLng, zoom: Float) -> Unit = { center, zoom ->
        Log.v(TAG_COMPOSE, "#MapView.observer args : center=$center, zoom=$zoom")
    }
) {
    Log.v(TAG_COMPOSE, "#MapView args : initCenter=$initCenter, initZoom=$initZoom, mapObserver=$mapObserver")

    val cameraPositionState = rememberCameraPositionState()
    if (null != initCenter && null != initZoom) {
        cameraPositionState.position = CameraPosition.fromLatLngZoom(initCenter, initZoom)
    } else {
        mapObserver(cameraPositionState.position.target, cameraPositionState.position.zoom)
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

@Composable
@Preview(showBackground = true)
@SuppressLint("ComposableNaming")
fun preview_MapView() {
    ParkingTheme {
        MapView()
    }
}
