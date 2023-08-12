package com.github.hemoptysisheart.parking.app.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    .clickable { gotoDestinationSearch() }
                    .padding(10.dp, 10.dp),
            verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier
                        .weight(1F),
                readOnly = true,
                leadingIcon = { SearchButton() },
                placeholder = { TextBodyMedium(text = text) },
                shape = RoundedCornerShape(30.dp)
        )
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
