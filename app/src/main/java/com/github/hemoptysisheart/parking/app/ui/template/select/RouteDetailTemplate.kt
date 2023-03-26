package com.github.hemoptysisheart.parking.app.ui.template.select

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRoute.ROUTE_新宿駅_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.domain.Route
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RouteDetailTemplate(route: Route, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier
            .background(Color.White)
            .padding(5.dp, 10.dp, 5.dp, 0.dp)
    ) {
        stickyHeader {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = route.parking.name,
                    modifier = Modifier.weight(1f),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Button(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(R.string.select_route_start_navigation_button_label))
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
        item {
            Text(text = "$route")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_RouteDetailTemplate() {
    ParkingTheme {
        RouteDetailTemplate(ROUTE_新宿駅_패밀리마트_카부키쵸키타점)
    }
}
