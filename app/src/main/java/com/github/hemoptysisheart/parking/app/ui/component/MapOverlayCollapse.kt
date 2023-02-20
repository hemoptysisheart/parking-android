package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.preview.Locations.株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun MapOverlayCollapse(
    destination: Location? = null,
    onExtend: () -> Unit = { }
) {
    Log.v(TAG_COMPOSE, "#MapOverlayCollapse args : destination=$destination, onExtend=$onExtend")

    Column(
        Modifier
            .fillMaxWidth()
            .zIndex(1.0F)
    ) {
        MapOverlayCollapseHeader(destination, onExtend)
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0)
@SuppressLint("ComposableNaming")
fun preview_MapOverlayCollapse_destinationNull() {
    ParkingTheme {
        MapOverlayCollapse()
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0)
@SuppressLint("ComposableNaming")
fun preview_MapOverlayCollapse_withDestination() {
    ParkingTheme {
        MapOverlayCollapse(株式会社ＡＡＡ)
    }
}
