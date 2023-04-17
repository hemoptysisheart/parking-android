package com.github.hemoptysisheart.parking.app.ui.atom.icon

import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.github.hemoptysisheart.parking.app.ui.support.ManeuverRes
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.domain.Maneuver

@Composable
fun Maneuver(
    maneuver: Maneuver,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    ManeuverRes[maneuver].run {
        Icon(imageVector, stringResource(description), modifier, tint)
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_Maneuver(@PreviewParameter(ManeuverProvider::class) maneuver: Maneuver) {
    ParkingTheme {
        Maneuver(maneuver = maneuver)
    }
}

class ManeuverProvider : PreviewParameterProvider<Maneuver> {
    override val values = Maneuver.values().asSequence()

    override val count = Maneuver.values().size
}
