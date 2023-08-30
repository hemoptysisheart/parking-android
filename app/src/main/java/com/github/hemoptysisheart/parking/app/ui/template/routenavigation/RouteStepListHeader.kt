package com.github.hemoptysisheart.parking.app.ui.template.routenavigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.Divider
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.resource.TransportationRes
import com.github.hemoptysisheart.parking.app.ui.resource.backgroundColor
import com.github.hemoptysisheart.parking.app.ui.resource.color
import com.github.hemoptysisheart.parking.domain.route.Transportation

@Composable
fun RouteStepListHeader(transportation: Transportation) {
    val res = TransportationRes[transportation]

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
                color = res.color()
        )
    }
}

@Composable
@ComponentPreview
@OptIn(ExperimentalFoundationApi::class)
fun Preview_RouteStepListHeader() {
    ComponentPreviewContainer {
        LazyColumn {
            Transportation.values().forEachIndexed { index, transportation ->
                if (0 < index) {
                    item { Divider() }
                }
                stickyHeader {
                    RouteStepListHeader(transportation = transportation)
                }
            }
        }
    }
}
