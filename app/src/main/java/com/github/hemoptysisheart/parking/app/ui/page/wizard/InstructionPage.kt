package com.github.hemoptysisheart.parking.app.ui.page.wizard

import androidx.compose.runtime.Composable
import com.github.hemoptysisheart.parking.app.interaction.wizard.InstructionInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewInstructionViewModel
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.wizard.InstructionViewModel

/**
 * 마법사 - 앱 소개(`wizard/instruction`)
 *
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54366-25117&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54303-34815&mode=design
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-649
 */
@Composable
fun InstructionPage(
        interaction: InstructionInteraction,
        viewModel: InstructionViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#InstructionPage args : interaction=$interaction")

    val closable = viewModel.closeable.collect()

    InstructionPageContent(interaction = interaction, closable = closable)
}

@Composable
@PagePreview
fun Preview_InstructionPage() {
    PagePreviewContainer {
        InstructionPage(
                interaction = InstructionInteraction(it),
                viewModel = previewInstructionViewModel()
        )
    }
}
