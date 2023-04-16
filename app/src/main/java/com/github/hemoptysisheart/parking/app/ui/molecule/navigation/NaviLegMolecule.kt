package com.github.hemoptysisheart.parking.app.ui.molecule.navigation

import androidx.compose.foundation.layout.*
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
import com.ireward.htmlcompose.HtmlText
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_COMPOSE as LOGGER

@Composable
fun NaviLegMolecule(
    here: Location,
    leg: NaviLeg
) {
    LOGGER.v("#NaviLegMolecule args : here=$here, leg=$leg")

    Column(Modifier.padding(5.dp)) {
        Text(text = "${leg.start} -> ${leg.end}")
        leg.stepList.forEach {
            it.guideText?.let { txt ->
                Row {
                    Spacer(Modifier.width(10.dp))
                    HtmlText(txt)
                }
            }
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
