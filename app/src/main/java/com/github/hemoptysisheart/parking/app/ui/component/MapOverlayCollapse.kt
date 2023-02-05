package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun MapOverlayCollapse(
    onExtend: () -> Unit = { Log.v(TAG_COMPOSE, "#onExtend called.") }
) {
    Log.v(TAG_COMPOSE, "#MapOverlayCollapse args : onExtend=$onExtend")

    Column(Modifier.fillMaxWidth()) {
        MapOverlayCollapseHeader(onExtend)
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0)
@SuppressLint("ComposableNaming")
fun preview_MapOverlayCollapse() {
    ParkingTheme {
        MapOverlayCollapse()
    }
}
