package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.github.hemoptysisheart.parking.app.interaction.main.SelectParkingInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewSelectParkingViewModel
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.main.SelectParkingViewModel
import com.github.hemoptysisheart.parking.domain.place.Geolocation

/**
 * [주차장 선택](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-673)
 */
@Composable
fun SelectParkingPage(
        interaction: SelectParkingInteraction,
        viewModel: SelectParkingViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#SelectParkingPage args : viewModel=$viewModel")

    val here = viewModel.here.collect()
    val destination = viewModel.destination
    val parkingList = viewModel.parkingList.collect()
    LOGGER.v("#SelectParkingPage : here=$here, destination=$destination, parkingList=$parkingList")

    var showOverlay by remember(SelectParkingViewModel::class) {
        mutableStateOf(true)
    }

    SelectParkingPageContent(
            interaction = interaction,
            here = here,
            destination = destination,
            parkingList = parkingList,
            showOverlay = showOverlay,
            toggleOverlay = { showOverlay = !showOverlay },
            onMoveCamera = { latLng, zoom ->
                viewModel.onMoveCamera(Geolocation(latLng.latitude, latLng.longitude), zoom)
            }
    )
}

@Composable
@PagePreview
fun Preview_SelectParkingPage() {
    PagePreviewContainer {
        SelectParkingPage(SelectParkingInteraction(it), previewSelectParkingViewModel())
    }
}
