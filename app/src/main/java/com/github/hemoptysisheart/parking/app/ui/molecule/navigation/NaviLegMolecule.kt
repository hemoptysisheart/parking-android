package com.github.hemoptysisheart.parking.app.ui.molecule.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.atom.icon.Maneuver
import com.github.hemoptysisheart.parking.app.ui.preview.LOCATION_신주쿠역
import com.github.hemoptysisheart.parking.app.ui.preview.ROUTE_新宿駅_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.domain.deprecate.Location
import com.github.hemoptysisheart.parking.domain.deprecate.NaviLeg
import com.ireward.htmlcompose.HtmlText
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_COMPOSE as LOGGER

@Composable
fun NaviLegMolecule(
    here: Location,
    leg: NaviLeg
) {
    LOGGER.v("#NaviLegMolecule args : here=$here, leg=$leg")

    Column(Modifier.padding(5.dp)) {
        leg.stepList.forEachIndexed { _, step ->
            step.guideText?.let { txt ->
                // TODO NaviStep UI 분리하기.
                Row(
                    modifier = Modifier.padding(10.dp, 3.dp, 3.dp, 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Maneuver(step.maneuver)
                    Spacer(Modifier.width(10.dp))
                    Column {
                        HtmlText(text = txt, modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_NaviLegMolecule() {
    ParkingTheme {
        NaviLegMolecule(LOCATION_신주쿠역, ROUTE_新宿駅_패밀리마트_카부키쵸키타점.driving!!.legList[0])
    }
}
