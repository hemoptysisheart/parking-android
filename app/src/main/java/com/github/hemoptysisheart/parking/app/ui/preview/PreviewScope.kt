package com.github.hemoptysisheart.parking.app.ui.preview

import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

fun LazyGridScope.preview(
        @StringRes label: Int,
        button: @Composable (String) -> Unit
) {
    item {
        Column(
                modifier = Modifier
                        .border(1.dp, MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2F))
                        .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            button(stringResource(label))
            Text(text = stringResource(label), color = MaterialTheme.colorScheme.onBackground)
        }
    }
}