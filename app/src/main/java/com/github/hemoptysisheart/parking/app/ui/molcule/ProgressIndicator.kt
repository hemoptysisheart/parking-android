package com.github.hemoptysisheart.parking.app.ui.molcule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.support.rememberProgress
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.ui.LOGGER_COMPOSE as LOGGER

@Composable
fun ProgressIndicator(show: Boolean = rememberProgress()) {
    LOGGER.v("#ProgressIndicator args : show=$show")

    if (show) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_ProgressIndicator_Show() {
    ParkingTheme {
        Column(Modifier.fillMaxSize()) {
            ProgressIndicator(true)
            Spacer(modifier = Modifier.weight(1F))
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_ProgressIndicator_Hide() {
    ParkingTheme {
        Column(Modifier.fillMaxSize()) {
            ProgressIndicator(false)
            Spacer(modifier = Modifier.weight(1F))
        }
    }
}
