package com.github.hemoptysisheart.parking.app.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.configuration.LOGGER_COMPOSE as LOGGER

@Composable
fun HeaderTemplate(
    gotoSearch: () -> Unit = {}
) {
    LOGGER.v("#HeaderTemplate")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .zIndex(10f)
    ) {
        Text(
            text = "",
            modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .padding(15.dp, 5.dp)
                .clickable { gotoSearch() },
            fontSize = 30.sp
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_HeaderTemplate() {
    ParkingTheme {
        HeaderTemplate()
    }
}
