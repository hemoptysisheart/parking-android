package com.github.hemoptysisheart.parking.app.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.main.GlobalHeaderInteraction
import com.github.hemoptysisheart.parking.app.ui.template.GlobalHeader
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun PreviewPage(content: @Composable (BaseInteraction) -> Unit) {
    ParkingTheme {
        val baseInteraction = previewBaseInteraction()
        GlobalHeader(
                interaction = GlobalHeaderInteraction(baseInteraction),
                viewModel = previewGlobalHeaderViewModel()
        )
        content(baseInteraction)
    }
}
