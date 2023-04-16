package com.github.hemoptysisheart.parking.app.ui.molecule.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRoute
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.NaviLeg

@Composable
fun NaviLegMolecule(
    here: Location,
    leg: NaviLeg
) {
    Column(Modifier.padding(5.dp, 10.dp)) {
        Text(text = "${leg.start} -> ${leg.end}")
        leg.stepList.forEach {
            Text(text = "${it.guideText}", modifier = Modifier.padding(10.dp, 3.dp, 3.dp, 3.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_NaviLegMolecule() {
    ParkingTheme {
        NaviLegMolecule(PreviewLocation.LOCATION_신주쿠역, PreviewRoute.ROUTE_新宿駅_패밀리마트_카부키쵸키타점.driving!!.legList[0])
    }
}
