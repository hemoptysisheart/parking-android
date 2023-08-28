package com.github.hemoptysisheart.parking.app.ui.template.selectroute

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.domain.route.Route

/**
 * 경로 정보
 */
@Composable
fun RouteListItem(route: Route, onClickStartNavigation: (Route) -> Unit = { }) {
    Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
    ) {
        Column(modifier = Modifier.weight(1F)) {
            TextLabelMedium(
                    text = "➡️ ${route.parking.name} ➡️ ${route.destination.name}",
                    color = MaterialTheme.colorScheme.onBackground
            )
        }
        IconButton(onClick = { onClickStartNavigation(route) }) {
            Icon(
                    imageVector = Icons.Default.Directions,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
@ComponentPreview
fun Preview_RouteListItem() {
    ComponentPreviewContainer {
        //RouteListItem()
    }
}
