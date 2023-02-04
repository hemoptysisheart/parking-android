package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun MapOverlayExtend() {
    Log.v(Constant.TAG_COMPOSE, "#MapOverlayExtend called.")

    LazyColumn(Modifier.fillMaxSize()) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .zIndex(1.0F),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = "관심 장소 쿼리",
                    onValueChange = {},
                    modifier = Modifier.weight(1.0F)
                )
                Spacer(modifier = Modifier.width(10.dp))
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(0.1F)
                        .padding(3.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "관심 장소 필터 설정",
                        modifier = Modifier.scale(1.1F)
                    )
                }
            }
        }
        item { Spacer(modifier = Modifier.height(10.dp)) }
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

@Composable
@Preview(showBackground = true)
@SuppressLint("ComposableNaming")
fun preview_MapOverlayExtend() {
    ParkingTheme {
        MapOverlayExtend()
    }
}