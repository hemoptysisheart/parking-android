package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
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
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun MapOverlayCollapse(
    onExpand: () -> Unit = { Log.v(TAG_COMPOSE, "#onExpand called.") }
) {
    Log.v(TAG_COMPOSE, "#MapOverlayCollapse args : onExpand=$onExpand")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .zIndex(1.0F),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "관심 장소",
            modifier = Modifier
                .weight(1.0F)
                .background(Color.White, RoundedCornerShape(20.dp))
                .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(20.dp))
                .padding(10.dp, 1.dp)
                .clickable { onExpand() }
        )
        Spacer(modifier = Modifier.width(10.dp))
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(0.1F)
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "관심 장소 필터 설정",
                modifier = Modifier
                    .scale(1.1F)
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp))
                    .padding(3.dp),
                tint = Color.Black
            )
        }
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
