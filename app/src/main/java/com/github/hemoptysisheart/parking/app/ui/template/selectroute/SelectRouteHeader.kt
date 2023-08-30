package com.github.hemoptysisheart.parking.app.ui.template.selectroute

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.BackButton
import com.github.hemoptysisheart.parking.app.ui.molecule.TitleDestination
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_로손편의점_니시신주쿠_7_10_19
import com.github.hemoptysisheart.parking.domain.place.Place

@Composable
fun SelectRouteHeader(
        destination: Place,
        onClickGoBack: () -> Unit = { }
) {
    Row(
            modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton(color = MaterialTheme.colorScheme.onBackground, onClick = onClickGoBack)
        TitleDestination(destination)
    }
}

@Composable
@ComponentPreview
fun Preview_SelectRouteHeader() {
    ComponentPreviewContainer {
        SelectRouteHeader(PLACE_로손편의점_니시신주쿠_7_10_19)
    }
}
