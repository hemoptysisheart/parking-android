package com.github.hemoptysisheart.parking.app.ui.molecule

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_로손편의점_니시신주쿠_7_10_19
import com.github.hemoptysisheart.parking.domain.place.Place

@Composable
fun RowScope.TitleDestination(destination: Place) {
    Column(
            modifier = Modifier
                    .weight(1F)
                    .background(MaterialTheme.colorScheme.background, RoundedCornerShape(30.dp))
                    .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(30.dp))
                    .padding(20.dp, 10.dp),
            verticalArrangement = Arrangement.Center
    ) {
        TextLabelMedium(
                text = destination.name,
                color = MaterialTheme.colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
        )
        TextBodySmall(
                text = destination.address,
                color = MaterialTheme.colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
        )
    }
}

@Composable
@ComponentPreview
fun Preview_TitleDestination() {
    ComponentPreviewContainer {
        Row {
            TitleDestination(PLACE_로손편의점_니시신주쿠_7_10_19)
        }
    }
}
