package com.github.hemoptysisheart.parking.app.ui.component.map

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.config.LogicConstants.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.domain.PlaceViewSimple
import com.github.hemoptysisheart.parking.app.ui.preview.domain.PlaceData
import com.github.hemoptysisheart.parking.domain.Place
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

/**
 * 기본 지도용 헤더.
 * - 검색어 입력 필드.
 * - 앱 설정 버튼.
 */
@Composable
fun MapHeader(place: Place?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PlaceViewSimple(place = place)

        Spacer(modifier = Modifier.width(10.dp))

        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = stringResource(R.string.label_preferences),
            modifier = Modifier
                .clickable {
                    Log.v(TAG_COMPOSE, "#MapHeader settings clicked.")
                }
                .background(Color.White, RoundedCornerShape(20.dp))
                .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp))
                .padding(5.dp)
        )
    }
}

@Composable
@Preview
fun MapHeaderPreviewPlaceNull() {
    ParkingTheme {
        MapHeader(null)
    }
}

@Composable
@Preview
fun MapHeaderPreviewPlaceDummy() {
    ParkingTheme {
        MapHeader(PlaceData.PLACE)
    }
}