package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.interaction.main.LandingMapInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewLandingMapViewModel
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.LandingMapViewModel

/**
 * [랜딩 맵](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-645)
 */
@Composable
fun LandingMapPage(
        interaction: LandingMapInteraction,
        viewModel: LandingMapViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#LandingMapPage args : interaction=$interaction, viewModel=$viewModel")

    val center = viewModel.center.collect()

    var showOverlay by remember(LandingMapViewModel::class) {
        mutableStateOf(true)
    }

    LandingMapPageContent(
            interaction = interaction,
            headerText = stringResource(R.string.page_landingmap_header_label),
            center = center,
            zoom = LandingMapViewModel.DEFAULT_ZOOM,
            showOverlay = showOverlay,
            toggleOverlay = { showOverlay = !showOverlay }
    )
}

@Composable
@PagePreview
fun LandingMapPage() {
    PagePreviewContainer {
        LandingMapPage(LandingMapInteraction(it), previewLandingMapViewModel())
    }
}
