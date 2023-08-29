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
import com.github.hemoptysisheart.parking.app.interaction.main.SelectRouteInteraction
import com.github.hemoptysisheart.parking.app.interaction.main.SelectRouteInteraction.Companion.ARG_DESTINATION
import com.github.hemoptysisheart.parking.app.interaction.main.SelectRouteInteraction.Companion.ARG_PARKING
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_MODE_GAKUEN_COCOON_TOWER_PARKING_LOT
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_로손편의점_니시신주쿠_7_10_19
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewSelectRouteViewModel
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.main.SelectRouteViewModel
import kotlinx.coroutines.launch

/**
 * 경로 선택
 *
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-681
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54312-34855&mode=design
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SelectRoutePage(
        interaction: SelectRouteInteraction,
        viewModel: SelectRouteViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#SelectRoutePage args : interaction=$interaction, viewModel=$viewModel")

    val parking = viewModel.parking
    val destination = viewModel.destination
    LOGGER.v("#SelectRoutePage : parking=$parking, destination=$destination")

    val here = viewModel.here.collect()
    val routeList = viewModel.routeList.collect()
    LOGGER.v("#SelectRoutePage : here=$here, routeList=$routeList")

    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberStandardBottomSheetState(skipHiddenState = false)
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState)
    var showOverlay by remember(SelectRouteViewModel::class) { mutableStateOf(true) }

    val toggleOverlay: () -> Unit = {
        showOverlay = !showOverlay

        coroutineScope.launch {
            if (showOverlay) {
                scaffoldState.bottomSheetState.show()
            } else {
                scaffoldState.bottomSheetState.hide()
            }
        }
    }

    SelectRoutePageContent(interaction, scaffoldState, showOverlay, here, parking, destination, routeList, toggleOverlay)
}

@Composable
@PagePreview
fun Preview_SelectRoutePage() {
    val savedStateHandle = SavedStateHandle()
    savedStateHandle[ARG_PARKING] = PLACE_MODE_GAKUEN_COCOON_TOWER_PARKING_LOT
    savedStateHandle[ARG_DESTINATION] = PLACE_로손편의점_니시신주쿠_7_10_19
    PagePreviewContainer {
        SelectRoutePage(SelectRouteInteraction(it), previewSelectRouteViewModel(savedStateHandle = savedStateHandle))
    }
}
