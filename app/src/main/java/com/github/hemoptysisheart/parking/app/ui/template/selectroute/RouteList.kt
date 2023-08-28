package com.github.hemoptysisheart.parking.app.ui.template.selectroute

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.Divider
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.domain.route.Route

/**
 * 경로 목록
 */
@Composable
fun RouteList(routeList: List<Route>) {
    LazyColumn(
            modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 150.dp)
                    .padding(10.dp, 0.dp)
    ) {
        routeList.forEachIndexed { index, route ->
            if (0 < index) {
                item {
                    Divider()
                }
            }
            item {
                RouteListItem(route)
            }
        }
    }

    Spacer(modifier = Modifier.height(40.dp))
}

@Composable
@ComponentPreview
fun Preview_RouteList() {
    ComponentPreviewContainer {
        Column {
            RouteList(emptyList())
        }
    }
}
