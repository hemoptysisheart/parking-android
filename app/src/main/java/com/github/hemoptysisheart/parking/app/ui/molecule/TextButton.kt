package com.github.hemoptysisheart.parking.app.ui.molecule

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview

@Composable
fun TextButton(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true
) {
    androidx.compose.material3.TextButton(onClick = onClick, modifier = modifier, enabled = enabled) {
        TextLabelMedium(text = text)
    }
}

@Composable
@ComponentPreview
fun TextButton() {
    TextButton(text = "text button", onClick = { })
}
