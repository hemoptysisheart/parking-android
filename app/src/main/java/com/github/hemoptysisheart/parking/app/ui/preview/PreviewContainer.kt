package com.github.hemoptysisheart.parking.app.ui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.main.GlobalHeaderInteraction
import com.github.hemoptysisheart.parking.app.ui.template.GlobalHeader
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun PagePreviewContainer(content: @Composable (BaseInteraction) -> Unit) {
    ParkingTheme {
        val baseInteraction = previewBaseInteraction()
        Column(
                modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
        ) {
            GlobalHeader(
                    interaction = GlobalHeaderInteraction(baseInteraction),
                    viewModel = previewGlobalHeaderViewModel()
            )
            content(baseInteraction)
        }
    }
}

@Composable
fun ComponentPreviewContainer(content: @Composable () -> Unit) {
    ParkingTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            content()
        }
    }
}
