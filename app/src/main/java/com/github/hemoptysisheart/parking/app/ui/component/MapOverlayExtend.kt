package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun MapOverlayExtend(
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    onCollapse: () -> Unit = { }
) {
    Log.v(TAG_COMPOSE, "#MapOverlayExtend args : onCollapse=$onCollapse")

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .zIndex(1.0F)
    ) {
        MapOverlayExtendHeader(query, onQueryChange, onCollapse)

        LazyColumn {
            items(30) {
                if (0 < it) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp, 3.dp)
                            .height(1.dp)
                            .background(Color.LightGray)
                    )
                }
                Text(text = "장소 검색 결과")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
@SuppressLint("ComposableNaming")
fun preview_MapOverlayExtend() {
    ParkingTheme {
        MapOverlayExtend()
    }
}