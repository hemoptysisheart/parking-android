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
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun MapOverlayCollapseHeader(
    destination: Location? = null,
    onExtend: () -> Unit = { }
) {
    Log.v(TAG_COMPOSE, "#MapOverlayPoi args : onExtend=$onExtend")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = destination?.name ?: "",
            modifier = Modifier
                .weight(1.0F)
                .background(Color.White, RoundedCornerShape(20.dp))
                .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(20.dp))
                .padding(10.dp, 1.dp)
                .clickable { onExtend() }
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
@Preview(showBackground = true)
@SuppressLint("ComposableNaming")
fun preview_MapOverlayCollapseHeader_destinationNull() {
    ParkingTheme {
        MapOverlayCollapseHeader()
    }
}

@Composable
@Preview(showBackground = true)
@SuppressLint("ComposableNaming")
fun preview_MapOverlayCollapseHeader_withDestination() {
    ParkingTheme {
        MapOverlayCollapseHeader(LOCATION_株式会社ＡＡＡ)
    }
}
