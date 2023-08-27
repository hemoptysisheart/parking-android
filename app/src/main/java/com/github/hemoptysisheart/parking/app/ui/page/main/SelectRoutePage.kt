package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.github.hemoptysisheart.parking.app.interaction.main.SelectRouteInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewSelectRouteViewModel
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.main.SelectRouteViewModel

/**
 * 경로 선택
 *
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-681
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54312-34855&mode=design
 */
@Composable
fun SelectRoutePage(
        interaction: SelectRouteInteraction,
        viewModel: SelectRouteViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#SelectRoutePage args : interaction=$interaction, viewModel=$viewModel")

    val parking = viewModel.parking
    val destination = viewModel.destination
    LOGGER.v("#SelectRoutePage : parking=$parking, destination=$destination")

    var showOverlay by remember(SelectRouteViewModel::class) { mutableStateOf(true) }

    SelectRoutePageContent(interaction)
}

@Composable
@PagePreview
fun Preview_SelectRoutePage() {
    PagePreviewContainer {
        SelectRoutePage(SelectRouteInteraction(it), previewSelectRouteViewModel())
    }
}
