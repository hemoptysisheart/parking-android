package com.github.hemoptysisheart.parking.app.ui.template.selectroute

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.Distance
import com.github.hemoptysisheart.parking.app.ui.molecule.Duration
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.core.R.string.domain_transport_drive
import com.github.hemoptysisheart.parking.core.R.string.domain_transport_walk
import com.github.hemoptysisheart.parking.domain.route.Route

/**
 * 경로 정보
 */
@Composable
fun RouteListItem(
        route: Route,
        onClickStartNavigation: (Route) -> Unit = { }
) {
    Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
    ) {
        Column(modifier = Modifier.weight(1F)) {
            TextLabelMedium(
                    text = "➡️ ${route.parking.name} ➡️ ${route.destination.name}",
                    color = MaterialTheme.colorScheme.onBackground
            )
            Row(modifier = Modifier.padding(0.dp, 5.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                        imageVector = Icons.Default.DirectionsCar,
                        contentDescription = stringResource(domain_transport_drive),
                        tint = MaterialTheme.colorScheme.primary
                )

                Distance(
                        distance = route.drive.distance,
                        modifier = Modifier.padding(5.dp, 0.dp),
                        color = MaterialTheme.colorScheme.primary
                )
                Duration(
                        duration = route.drive.duration,
                        modifier = Modifier.padding(5.dp, 0.dp),
                        color = MaterialTheme.colorScheme.primary
                )
            }
            Row(modifier = Modifier.padding(0.dp, 5.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                        imageVector = Icons.Default.DirectionsWalk,
                        contentDescription = stringResource(domain_transport_walk),
                        tint = MaterialTheme.colorScheme.secondary
                )
                Distance(
                        distance = route.walk.distance,
                        modifier = Modifier.padding(5.dp, 0.dp),
                        color = MaterialTheme.colorScheme.secondary
                )

                Duration(duration = route.walk.duration,
                        modifier = Modifier.padding(5.dp, 0.dp),
                        color = MaterialTheme.colorScheme.secondary
                )
            }
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
