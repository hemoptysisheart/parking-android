package com.github.hemoptysisheart.parking.app.ui.template.setting

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.molecule.BackButton
import com.github.hemoptysisheart.parking.app.ui.molecule.TextTitleMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer

/**
 * [`setting/header`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54319-25258&mode=design)
 */
@Composable
fun Header(
        @StringRes title: Int,
        onClickBack: () -> Unit = {}
) {
    val bottomColor = MaterialTheme.colorScheme.outlineVariant
    Box(
            Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
                    .drawBehind {
                        drawLine(
                                color = bottomColor,
                                start = Offset(0F, size.height),
                                end = Offset(size.width, size.height)
                        )
                    }
    ) {
        TextTitleMedium(
                text = stringResource(title),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp, 10.dp),
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
        )
        BackButton(color = MaterialTheme.colorScheme.onBackground, onClick = onClickBack)
    }
}

@Composable
@ComponentPreview
fun Preview_Header() {
    ComponentPreviewContainer {
        Header(title = R.string.page_search_setting_title)
    }
}
