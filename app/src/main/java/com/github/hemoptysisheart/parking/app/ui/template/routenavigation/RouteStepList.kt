package com.github.hemoptysisheart.parking.app.ui.template.routenavigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R.string.template_route_navigation_route_step_list_finish_navigation
import com.github.hemoptysisheart.parking.app.ui.molecule.Divider
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelLarge
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.domain.route.SubRoute

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun ColumnScope.RouteStepList(
        drive: SubRoute,
        walk: SubRoute,
        onClickCloseRouteNavigation: () -> Unit
) {
    LazyColumn(
            modifier = Modifier
                    .weight(1F)
                    .background(MaterialTheme.colorScheme.surface)
    ) {
        stickyHeader {
            RouteStepListHeader(drive)
        }

        drive.legList.flatMap { it.stepList }.forEachIndexed { index, step ->
            if (0 < index) {
                item { Divider() }
            }

            item {
                RouteStepListItem(step)
            }
        }

        stickyHeader {
            RouteStepListHeader(walk)
        }

        walk.legList.flatMap { it.stepList }.forEachIndexed { index, step ->
            if (0 < index) {
                item { Divider() }
            }

            item {
                RouteStepListItem(step)
            }
        }

        item {
            Button(onClick = onClickCloseRouteNavigation, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 20.dp)) {
                TextLabelLarge(text = stringResource(template_route_navigation_route_step_list_finish_navigation))
            }
        }
    }
}

@Composable
@ComponentPreview
fun Preview_RouteManeuver() {
    ComponentPreviewContainer {
        Column {
            // RouteStepList()
        }
    }
}
