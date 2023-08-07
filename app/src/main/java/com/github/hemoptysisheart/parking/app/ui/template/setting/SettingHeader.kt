package com.github.hemoptysisheart.parking.app.ui.template.setting

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.molecule.BackButton
import com.github.hemoptysisheart.parking.app.ui.molecule.TextTitleMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer

@Composable
fun SettingHeader(
        @StringRes title: Int,
        onBack: () -> Unit = {}
) {
    Box(modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)) {
        TextTitleMedium(
                text = stringResource(title),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp, 10.dp),
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
        )
        BackButton(color = MaterialTheme.colorScheme.onBackground, onClick = onBack)
    }
}

@Composable
@ComponentPreview
fun SettingHeader() {
    ComponentPreviewContainer {
        SettingHeader(title = R.string.template_setting_item_distance_title)
    }
}
