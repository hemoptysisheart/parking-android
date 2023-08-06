package com.github.hemoptysisheart.parking.app.ui.template.setting

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.molecule.BackButton
import com.github.hemoptysisheart.parking.app.ui.molecule.TextTitleMedium
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewComponent

@Composable
fun SettingHeader(
        @StringRes title: Int,
        modifier: Modifier = Modifier,
        onBack: () -> Unit = {}
) {
    Box(modifier = modifier) {
        TextTitleMedium(
                text = stringResource(title),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp, 10.dp),
                textAlign = TextAlign.Center
        )
        BackButton(onClick = onBack)
    }
}

@Composable
@Preview(name = "light mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL)
@Preview(name = "dark mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL)
fun SettingHeader() {
    PreviewComponent {
        SettingHeader(title = R.string.template_setting_item_distance_title)
    }
}
