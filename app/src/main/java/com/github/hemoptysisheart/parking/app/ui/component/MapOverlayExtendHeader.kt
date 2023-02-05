package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun MapOverlayExtendHeader(
    query: String = "",
    onCollapse: () -> Unit = { Log.v(Constant.TAG_COMPOSE, "#onCollapse called.") }
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .zIndex(1.0F),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onCollapse() },
            modifier = Modifier
                .weight(0.1F)
                .padding(3.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "돌아가기 버튼",
                modifier = Modifier
                    .scale(1.1F)
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp))
                    .padding(3.dp),
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        OutlinedTextField(
            value = query,
            onValueChange = {},
            modifier = Modifier.weight(1.0F),
            placeholder = {
                Text(stringResource(R.string.map_overlay_query_placeholder))
            }
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
fun preview_MapOverlayExtendHeader() {
    ParkingTheme {
        MapOverlayExtendHeader()
    }
}

