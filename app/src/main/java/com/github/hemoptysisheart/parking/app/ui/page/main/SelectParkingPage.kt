package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import com.github.hemoptysisheart.parking.app.interaction.main.SelectParkingInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_로손오오테센터빌딩점_1_1_3
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewSelectParkingViewModel
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.main.SelectParkingViewModel
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets.UTF_8

/**
 * [주차장 선택](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-673)
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SelectParkingPage(
        interaction: SelectParkingInteraction,
        viewModel: SelectParkingViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#SelectParkingPage args : viewModel=$viewModel")

    val here = viewModel.here.collect()
    val destination = viewModel.destination
    val parkingRadius = viewModel.parkingRadius
    val parkingList = viewModel.parkingList.collect()
    LOGGER.v("#SelectParkingPage : here=$here, destination=$destination, parkingRadius=$parkingRadius, parkingList=$parkingList")

    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberStandardBottomSheetState(skipHiddenState = false)
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState)
    var showOverlay by remember(SelectParkingViewModel::class) { mutableStateOf(true) }
    val toggleOverlay: () -> Unit = {
        showOverlay = !showOverlay

        coroutineScope.launch {
            if (showOverlay) {
                scaffoldState.bottomSheetState.show()
            } else {
                scaffoldState.bottomSheetState.hide()
            }
        }
        // TODO sheetPeekHeight 등을 설정해서  하단 시트를 완전히 숨기기.
    }
    val onMoveCamera: (LatLng, Float) -> Unit = { latLng, zoom ->
        viewModel.onMoveCamera(Geolocation(latLng.latitude, latLng.longitude), zoom)
    }

    SelectParkingPageContent(
            interaction = interaction,
            scaffoldState = scaffoldState,
            here = here,
            destination = destination,
            parkingRadius = parkingRadius,
            parkingList = parkingList,
            showOverlay = showOverlay,
            toggleOverlay = toggleOverlay,
            onMoveCamera = onMoveCamera
    )
}

@Composable
@PagePreview
fun Preview_SelectParkingPage() {
    val savedStateHandle = SavedStateHandle()
    savedStateHandle[URLEncoder.encode("${PLACE_로손오오테센터빌딩점_1_1_3.id.toURI()}", UTF_8)] = PLACE_로손오오테센터빌딩점_1_1_3
    PagePreviewContainer {
        SelectParkingPage(SelectParkingInteraction(it), previewSelectParkingViewModel(savedStateHandle))
    }
}
