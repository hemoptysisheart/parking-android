package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.support.bitmapDescriptor
import com.github.hemoptysisheart.parking.core.extension.latLng
import com.github.hemoptysisheart.parking.core.extension.points
import com.github.hemoptysisheart.parking.core.logging.logArgs
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItemLocation
import com.github.hemoptysisheart.parking.domain.Route
import com.github.hemoptysisheart.parking.ui.theme.LightSkyBlue
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

/**
 * 기본 지도 출력하기.
 *
 * @param destination 목적지.
 * @param parkingList 주차장 목록. TODO `routeList`로 대체.
 * @param routeList 경로 목록.
 * @param focusedRoute 포커스를 가진 목록.
 * @param cameraPositionState 지도 카메라 위치.
 * @param onMapClick 맵 선택시 처리 로직.
 */
@Composable
fun Map(
    destination: Location? = null,
    parkingList: List<RecommendItemLocation> = listOf(),
    routeList: List<Route> = listOf(),
    focusedRoute: Route? = null,
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    onMapClick: (LatLng) -> Unit = { Log.v(TAG_COMPOSE, "#onMapClick called.") }
) {
    logArgs(
        TAG_COMPOSE,
        "Map",
        "destination" to destination,
        "parkingList" to parkingList,
        "focusedRoute" to focusedRoute,
        "cameraPositionState" to cameraPositionState,
        "onMapClick" to onMapClick
    )

    val context = LocalContext.current
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
        mutableStateOf(MapProperties(isBuildingEnabled = true, isMyLocationEnabled = true))
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings,
        onMapClick = onMapClick
    ) {
        destination?.let {
            val destinationMarkerState = rememberMarkerState(key = it.id, position = it.latLng)
            Marker(
                state = destinationMarkerState,
                title = it.name,
                icon = bitmapDescriptor(context, R.drawable.map_marker_destination)
            )
        }

        parkingList.forEach {
            Marker(
                state = rememberMarkerState(key = it.id, position = it.item.latLng),
                title = it.item.name,
                icon = bitmapDescriptor(context, R.drawable.map_marker_parking)
            )
        }
        focusedRoute?.run {
            Polyline(points = driving.overview.points, color = Blue, width = 15f, zIndex = 1f)
            Polyline(points = walking.overview.points, color = Gray, width = 15f, zIndex = 1f)
        }
        for (route in routeList) {
            if (focusedRoute != route) {
                Polyline(points = route.driving.overview.points, color = LightSkyBlue)
                Polyline(points = route.walking.overview.points, color = LightGray)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
@SuppressLint("ComposableNaming")
fun preview_MapView_destinationNull() {
    ParkingTheme {
        Map()
    }
}
