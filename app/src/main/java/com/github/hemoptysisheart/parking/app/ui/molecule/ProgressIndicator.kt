package com.github.hemoptysisheart.parking.app.ui.molecule

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.support.rememberProgress

/**
 * [`input/slider`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54316-25174&mode=design)
 */
@Composable
fun ProgressIndicator(show: Boolean = rememberProgress()) {
    LOGGER.v("#ProgressIndicator args : show=$show")

    if (show) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
@ComponentPreview
fun Preview_ProgressIndicator_Show() {
    ComponentPreviewContainer {
        ProgressIndicator(true)
    }
}

@Composable
@ComponentPreview
fun Preview_ProgressIndicator_Hide() {
    ComponentPreviewContainer {
        ProgressIndicator(false)
    }
}
