package com.github.hemoptysisheart.parking.app.ui.molecule

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer

/**
 * [`divider`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54320-713&mode=design)
 */
@Composable
fun Divider() {
    androidx.compose.material3.Divider(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 1.dp),
            color = MaterialTheme.colorScheme.outlineVariant
    )
}


@Composable
@ComponentPreview
fun Preview_Divider() {
    ComponentPreviewContainer {
        Divider()
    }
}
