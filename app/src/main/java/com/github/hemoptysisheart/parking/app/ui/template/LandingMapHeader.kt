package com.github.hemoptysisheart.parking.app.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.SearchButton
import com.github.hemoptysisheart.parking.app.ui.molecule.SettingsButton
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer

/**
 * [`landingMap/header`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54397-937&mode=design)
 */
@Composable
fun LandingMapHeader(
        text: String,
        gotoDestinationSearch: () -> Unit = { },
        gotoSetting: () -> Unit = { }
) {
    Row(
            modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(10.dp, 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedButton(
                onClick = gotoDestinationSearch,
                modifier = Modifier
                        .weight(1F),
                colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = MaterialTheme.colorScheme.outlineVariant
                )
        ) {
            SearchButton()
            TextBodyMedium(text = text, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Start)
        }
        Spacer(modifier = Modifier.width(10.dp))
        SettingsButton(onClick = gotoSetting, color = MaterialTheme.colorScheme.onBackground)
    }
}

@Composable
@ComponentPreview
fun Preview_LandingMapHeader() {
    ComponentPreviewContainer {
        LandingMapHeader("헤더 안내")
    }
}
