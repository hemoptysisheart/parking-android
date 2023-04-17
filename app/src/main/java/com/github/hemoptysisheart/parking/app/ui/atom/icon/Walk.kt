package com.github.hemoptysisheart.parking.app.ui.atom.icon

import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
fun Walk(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Icon(Icons.Default.DirectionsWalk, stringResource(R.string.domain_partial_route_walk), modifier, tint)
}

@Composable
@Preview(showBackground = true)
fun Preview_Walking() {
    ParkingTheme {
        Walk()
    }
}
