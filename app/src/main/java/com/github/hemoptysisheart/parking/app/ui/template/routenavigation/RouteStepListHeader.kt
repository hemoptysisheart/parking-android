package com.github.hemoptysisheart.parking.app.ui.template.routenavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.Distance
import com.github.hemoptysisheart.parking.app.ui.molecule.Duration
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.resource.TransportationRes
import com.github.hemoptysisheart.parking.app.ui.resource.backgroundColor
import com.github.hemoptysisheart.parking.app.ui.resource.color
import com.github.hemoptysisheart.parking.domain.route.SubRoute

@Composable
fun RouteStepListHeader(subRoute: SubRoute) {
    val res = TransportationRes[subRoute.transportation]

    Row(
            modifier = Modifier
                    .fillMaxWidth()
                    .background(res.backgroundColor())
                    .padding(10.dp, 5.dp),
            verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
                imageVector = res.icon,
                contentDescription = stringResource(res.label),
                modifier = Modifier.padding(5.dp, 0.dp),
                tint = res.color()
        )
        TextLabelMedium(
                text = stringResource(res.label),
                modifier = Modifier.weight(1F),
                color = res.color()
        )

        TextLabelMedium(
                text = stringResource(res.label),
                modifier = Modifier
                        .weight(3F)
                        .padding(0.dp, 3.dp),
                color = MaterialTheme.colorScheme.onSurface
        )
        Distance(
                distance = subRoute.distance,
                modifier = Modifier
                        .padding(3.dp),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
        )
        Duration(
                duration = subRoute.duration,
                modifier = Modifier
                        .padding(3.dp),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
        )
    }
}

@Composable
@ComponentPreview
fun Preview_RouteStepListHeader() {
    ComponentPreviewContainer {
        LazyColumn {
            // TODO
        }
    }
}
