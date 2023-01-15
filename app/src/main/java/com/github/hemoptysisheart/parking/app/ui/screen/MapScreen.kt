package com.github.hemoptysisheart.parking.app.ui.component.map

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.hemoptysisheart.parking.app.ui.configuration.UiConstants.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.viewmodel.MapViewModel
import com.github.hemoptysisheart.parking.core.dummy.domain.DummyPlace
import com.github.hemoptysisheart.parking.core.dummy.model.DummyLocationModel
import com.github.hemoptysisheart.parking.core.dummy.model.DummyMapModel
import com.github.hemoptysisheart.parking.core.dummy.model.DummyPlaceModel
import com.github.hemoptysisheart.parking.domain.Coordinate
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.github.hemoptysisheart.util.TruncatedTimeProvider
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import java.util.*

/**
 * 지도에 정보를 표시한다.
 *
 * UI : [MapScreen](https://www.figma.com/file/I3LN6lcAVaAXlNba0kBKPN/Parking?node-id=112%3A508&t=TzUdFxNeMKN4ZpTv-4)
 */
@Composable
@Suppress("MoveLambdaOutsideParentheses")
fun MapScreen(
    placeId: String? = null,
    viewModel: MapViewModel = hiltViewModel(),
    openSearch: (center: Coordinate, zoom: Float) -> Unit = { center, zoom ->
        Log.v(TAG_COMPOSE, "#openSearch args : center=$center, zoom=$zoom")
    }
) {
    Log.v(TAG_COMPOSE, "#MapView args : placeId=$placeId, viewModel=$viewModel, openSearch=$openSearch")

    val destination by remember { viewModel.destination }
    val center by remember { viewModel.center }
    val zoom by remember { viewModel.zoom }

    if (null != placeId) {
        viewModel.setDestination(placeId)
    }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            center.run { LatLng(latitude, longitude) },
            zoom
        )
    }
    viewModel.update(cameraPositionState.position.target, cameraPositionState.position.zoom)

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

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (header, mapControl, map) = createRefs()

        MapHeader(
            Modifier
                .constrainAs(header) {
                    top.linkTo(parent.top, 0.dp)
                    start.linkTo(parent.start, 0.dp)
                    end.linkTo(parent.end, 0.dp)
                }
                .fillMaxWidth()
                .zIndex(1.0F),
            destination,
            { openSearch(center, zoom) }
        )

        Text(
            text = "\uD83D\uDD18",
            modifier = Modifier
                .constrainAs(mapControl) {
                    bottom.linkTo(parent.bottom, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                }
                .background(Color.White, RoundedCornerShape(20.dp))
                .padding(8.dp)
                .clickable {
                    Log.v(TAG_COMPOSE, "#myLocation.onClick")
                    cameraPositionState.position = CameraPosition
                        .fromLatLngZoom(LatLng(center.latitude, center.longitude), zoom)
                }
                .zIndex(1.0F),
            fontSize = 18.sp
        )

        GoogleMap(
            modifier = Modifier
                .constrainAs(map) {}
                .fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = properties,
            uiSettings = uiSettings,
            onMapClick = {
                Log.d(TAG_COMPOSE, "map.onMapClick args : latLng=$it")
                // TODO 입력 UI 보이기/숨기기
            }
        )
    }
}

@Composable
@Preview(name = "목적지가 없는 초기상태.", showSystemUi = true, showBackground = true)
fun MapScreenPreviewInit() {
    ParkingTheme {
        MapScreen(viewModel = MapViewModel(DummyLocationModel, DummyPlaceModel, DummyMapModel, TruncatedTimeProvider()))
    }
}

@Composable
@Preview(name = "목적지를 선택한 상태.", showSystemUi = true, showBackground = true)
fun MapScreenPreviewSearch() {
    ParkingTheme {
        MapScreen(
            placeId = DummyPlace.QUERY_PLACE.id,
            viewModel = MapViewModel(DummyLocationModel, DummyPlaceModel, DummyMapModel, TruncatedTimeProvider())
        )
    }
}