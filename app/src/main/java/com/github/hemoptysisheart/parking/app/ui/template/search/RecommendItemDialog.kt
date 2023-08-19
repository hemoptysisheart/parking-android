package com.github.hemoptysisheart.parking.app.ui.template.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.domain.common.Object

/**
 * [``]()
 */
@Composable
fun <T : Object> RecommendItemDialog(
        item: T,
        onDismissRequest: () -> Unit = { }
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Column(
                Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(20.dp))
                        .padding(20.dp)
        ) {
            TextBodyMedium(
                    text = item.toString(),
                    modifier = Modifier.padding(0.dp, 10.dp),
                    color = MaterialTheme.colorScheme.onSurface
            )

            Button(onClick = onDismissRequest, modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp)
            ) {
                Text(text = stringResource(R.string.global_close_label))
            }
        }
    }
}


@Composable
@ComponentPreview
fun Preview_RecommendItemDialog() {
    ComponentPreviewContainer {
        // RecommendItemDialog()
    }
}
