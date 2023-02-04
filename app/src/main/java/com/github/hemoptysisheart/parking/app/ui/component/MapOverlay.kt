package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.state.MainScreenState
import com.github.hemoptysisheart.parking.app.ui.state.OverlayState.*
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun MapOverlay(state: MainScreenState) {
    Log.v(TAG_COMPOSE, "#MapOverlay args : state=$state")

    when (state.overlayState) {
        COLLAPSE ->
            MapOverlayCollapse()
        EXTEND ->
            MapOverlayExtend()
        else ->
            Log.w(TAG_COMPOSE, "#MapOverlay illegal state : state=$state")
    }
}

@Composable
@Preview(showBackground = true)
@SuppressLint("ComposableNaming")
fun preview_MapOverlay_collapse() {
    ParkingTheme {
        MapOverlay(MainScreenState(COLLAPSE))
    }
}

@Composable
@Preview(showBackground = true)
@SuppressLint("ComposableNaming")
fun preview_MapOverlay_extend() {
    ParkingTheme {
        MapOverlay(MainScreenState(EXTEND))
    }
}
