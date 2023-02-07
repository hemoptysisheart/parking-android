package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.preview.RecommendItems.ITEM_株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.domain.RecommendItem
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun MapRecommendedItem(item: RecommendItem<*>) {
    Log.v(TAG_COMPOSE, "#MapRecommendedItem args : item=$item")
    Column(modifier = Modifier.padding(20.dp, 7.dp)) {
        Text(text = item.summary)
        item.detail?.let { detail ->
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = detail, color = Color.Gray)
        }
    }
}

@Composable
@Preview(showBackground = true)
@SuppressLint("ComposableNaming")
fun preview_MapRecommendedItem_GmpPlace() {
    ParkingTheme {
        MapRecommendedItem(ITEM_株式会社ＡＡＡ)
    }
}
