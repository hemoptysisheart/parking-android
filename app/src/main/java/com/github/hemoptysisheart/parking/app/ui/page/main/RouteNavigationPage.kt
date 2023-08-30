package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import com.github.hemoptysisheart.parking.app.interaction.main.RouteNavigationInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewRouteNavigationViewModel
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.main.RouteNavigationViewModel

/**
 * 경로 안내
 *
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-693
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54312-34862&mode=design
 */
@Composable
fun RouteNavigationPage(
        interaction: RouteNavigationInteraction,
        viewModel: RouteNavigationViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#RouteNavigationPage args : interaction=$interaction")

    val drive = viewModel.drive
    val walk = viewModel.walk

    RouteNavigationPageContent(interaction, drive, walk)
}

@Composable
@PagePreview
fun Preview_RouteNavigationPage() {
    PagePreviewContainer {
        val savedStateHandle = SavedStateHandle()
        // TODO 프리뷰용 경로 추가.
        // TODO 경로 id 설정.
        RouteNavigationPage(RouteNavigationInteraction(it), previewRouteNavigationViewModel(savedStateHandle))
    }
}
