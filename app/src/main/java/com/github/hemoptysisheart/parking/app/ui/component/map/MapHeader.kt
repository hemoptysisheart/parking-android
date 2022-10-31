package com.github.hemoptysisheart.parking.app.ui.component.map

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.config.Constants.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.container.Header
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

/**
 * 기본 지도용 헤더.
 * - 검색어 입력 필드.
 * - 앱 설정 버튼.
 */
@Composable
fun MapHeader() {
    Header {
        OutlinedTextField(
            value = "",
            onValueChange = {
                Log.v(TAG_COMPOSE, "#MapHeader.onValueChange args : value=$it")
            },
            modifier = Modifier
                .weight(1.0F)
                .background(Color.White),
            enabled = true
        )

        Spacer(modifier = Modifier.width(10.dp))

        IconButton(
            onClick = {
                Log.v(TAG_COMPOSE, "#MapHeader.onClick")
            },
            modifier = Modifier
                .border(1.dp, Color.Gray, RoundedCornerShape(5.dp))
                .background(Color.White, RoundedCornerShape(5.dp))
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = stringResource(R.string.label_preferences),
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}

@Composable
@Preview
fun MapHeaderPreview() {
    ParkingTheme {
        MapHeader()
    }
}