package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.runtime.Composable
import com.github.hemoptysisheart.parking.app.interaction.main.DestinationSearchInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewDestinationSearchViewModel
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.ui.template.search.RecommendItemDialog
import com.github.hemoptysisheart.parking.app.viewmodel.main.DestinationSearchViewModel

/**
 * 목적지 검색
 *
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-653
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54311-34835&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54416-1445&mode=design
 */
@Composable
fun DestinationSearchPage(
        interaction: DestinationSearchInteraction,
        viewModel: DestinationSearchViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#DestinationSearchPage args : interaction=$interaction, viewModel=$viewModel")

    val query = viewModel.query.collect()
    val recommendItemList = viewModel.recommendItemList.collect()
    val detail = viewModel.detail.collect()

    detail?.let {
        RecommendItemDialog(item = it, onDismissRequest = viewModel::clearDetail)
    }

    DestinationSearchPageContent(
            interaction = interaction,
            query = query,
            recommendItemList = recommendItemList,
            onChangeQuery = viewModel::onChangeQuery,
            showItemDetail = viewModel::showDetail
    )
}

@Composable
@PagePreview
fun Preview_DestinationSearchPage() {
    PagePreviewContainer {
        DestinationSearchPage(
                interaction = DestinationSearchInteraction(it),
                viewModel = previewDestinationSearchViewModel()
        )
    }
}
