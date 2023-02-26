package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.support.bitmapDescriptor
import com.github.hemoptysisheart.parking.core.client.google.dto.DirectionsRoute
import com.github.hemoptysisheart.parking.core.logging.logArgs
import com.github.hemoptysisheart.parking.core.model.dto.toLatLng
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItemLocation
import com.github.hemoptysisheart.parking.domain.Route
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

/**
 * 기본 지도 출력하기.
 *
 * @param cameraPositionState 지도 카메라 위치.
 */
@Composable
fun Map(
    destination: Location? = null,
    parkingList: List<RecommendItemLocation> = listOf(),
    routeList:List<Route<DirectionsRoute>> = listOf(),
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    onMapClick: (LatLng) -> Unit = { Log.v(TAG_COMPOSE, "#onMapClick called.") }
) {
    logArgs(
        TAG_COMPOSE,
        "Map",
        "destination" to destination,
        "parkingList" to parkingList,
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
        mutableStateOf(MapProperties(isBuildingEnabled = true, isMyLocationEnabled = true, isTrafficEnabled = true))
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings,
        onMapClick = onMapClick
    ) {
        destination?.let {
            val destinationMarkerState = rememberMarkerState(key = it.id, position = it.toLatLng())
            Marker(
                state = destinationMarkerState,
                title = it.name,
                icon = bitmapDescriptor(context, R.drawable.map_marker_destination)
            )
        }

        parkingList.forEach {
            Marker(
                state = rememberMarkerState(key = it.id, position = it.item.toLatLng()),
                title = it.item.name,
                icon = bitmapDescriptor(context, R.drawable.map_marker_parking)
            )

            for(route in routeList){
                Polyline(points = route.driving.overviewPolyline.points.map { it.toLatLng() }, color = Color.Blue)
                Polyline(points = route.walking.overviewPolyline.points.map { it.toLatLng() }, color = Color.Gray)
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
