package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.runtime.Composable
import com.github.hemoptysisheart.parking.app.interaction.main.LandingMapInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
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
}

@Composable
@PagePreview
fun LandingMapPage() {
    PagePreviewContainer {
        LandingMapPage(LandingMapInteraction(it))
    }
}
