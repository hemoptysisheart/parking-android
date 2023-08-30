package com.github.hemoptysisheart.parking.app.ui.molecule

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview

@Composable
fun TextButton(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        color: Color = MaterialTheme.colorScheme.onBackground,
        enabled: Boolean = true
) {
    androidx.compose.material3.TextButton(onClick = onClick, modifier = modifier, enabled = enabled) {
        TextLabelMedium(text = text, color = color)
    }
}

@Composable
@ComponentPreview
fun TextButton() {
    TextButton(text = "text button", onClick = { })
}
