package com.github.hemoptysisheart.parking.app.ui.page.wizard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.wizard.InstructionInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewInstructionViewModel
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.ui.template.WizardFooter
import com.github.hemoptysisheart.parking.app.ui.theme.Typography
import com.github.hemoptysisheart.parking.app.viewmodel.wizard.InstructionViewModel

/**
 * [마법사](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-649)
 */
@Composable
fun InstructionPage(
        interaction: InstructionInteraction,
        viewModel: InstructionViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#InstructionPage args : interaction=$interaction")

    InstructionPageContent(
            interaction = interaction,
            onClose = interaction::close,
            onNext = interaction::gotoLocation
    )
}

@Composable
internal fun InstructionPageContent(
        interaction: InstructionInteraction,
        onClose: () -> Unit = { },
        onNext: () -> Unit = {}
) {
    Column(Modifier
            .fillMaxSize()
            .padding(20.dp, 0.dp)) {
        Spacer(modifier = Modifier.weight(1F))
        Text(
                text = """
                파킹은 도심지에서 목적지 근처 주차장을 찾아줍니다.
                """.trimIndent(),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                style = Typography.bodyLarge
        )
        Spacer(modifier = Modifier.weight(1F))
        WizardFooter(
                onClose = onClose,
                onNext = onNext
        )
    }
}

@Composable
@PagePreview
fun Preview_InstructionPage() {
    PagePreviewContainer {
        InstructionPage(interaction = InstructionInteraction(it), viewModel = previewInstructionViewModel())
    }
}
