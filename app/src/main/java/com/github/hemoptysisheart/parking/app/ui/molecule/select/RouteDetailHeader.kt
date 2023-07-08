package com.github.hemoptysisheart.parking.app.ui.molecule.select

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
import com.github.hemoptysisheart.parking.app.ui.preview.ROUTE_新宿駅_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.domain.Route

@Composable
fun RouteDetailHeader(route: Route, gotoNavigation: (Route) -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = route.parking.name,
            modifier = Modifier.weight(1f),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.width(10.dp))
        Button(onClick = { gotoNavigation(route) }) {
            Text(text = stringResource(R.string.select_route_start_navigation_button_label))
        }
    }
}

@Composable
@Preview(showBackground = true)
@Suppress("NonAsciiCharacters")
fun Preview_RouteDetailHeader_新宿駅_패밀리마트_카부키쵸키타점() {
    ParkingTheme {
        RouteDetailHeader(ROUTE_新宿駅_패밀리마트_카부키쵸키타점)
    }
}
