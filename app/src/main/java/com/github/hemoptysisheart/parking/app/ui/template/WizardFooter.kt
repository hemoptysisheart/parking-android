package com.github.hemoptysisheart.parking.app.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.molecule.TextButton
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer

/**
 * [`wizard/footer`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54365-25089&mode=design)
 */
@Composable
fun WizardFooter(
        onClose: () -> Unit,
        onNext: () -> Unit
) {
    Row(
            modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(20.dp, 10.dp),
            verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(text = stringResource(R.string.global_close_label), onClick = onClose)
        Spacer(modifier = Modifier.weight(1F))
        Button(onClick = onNext) {
            TextBodyMedium(text = stringResource(R.string.global_next_label), color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Composable
@ComponentPreview
fun Preview_WizardFooter() {
    ComponentPreviewContainer {
        WizardFooter(onClose = {}, onNext = {})
    }
}
