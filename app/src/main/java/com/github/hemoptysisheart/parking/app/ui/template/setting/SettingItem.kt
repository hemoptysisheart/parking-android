package com.github.hemoptysisheart.parking.app.ui.template.setting

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer

/**
 * [`setting/item`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54410-1104&mode=design&t=z2zNocVNCcSFpatj-4)
 */
@Composable
fun SettingItem(@StringRes text: Int, onClick: () -> Unit) {
    Row(
            modifier = Modifier
                    .clickable { onClick() }
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp),
            verticalAlignment = Alignment.CenterVertically
    ) {
        TextBodyMedium(
                text = stringResource(text),
                modifier = Modifier
                        .fillMaxWidth()
                        .weight(1F),
                color = MaterialTheme.colorScheme.onBackground
        )
        Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = stringResource(text),
                tint = MaterialTheme.colorScheme.outline
        )
    }
}


@Composable
@ComponentPreview
fun Preview_SettingItem() {
    ComponentPreviewContainer {
        SettingItem(text = R.string.page_search_setting_title, onClick = {})
    }
}
