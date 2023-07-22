package com.github.hemoptysisheart.parking.app.ui.atom

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import java.text.NumberFormat

@Composable
fun Distance(distance: Double, modifier: Modifier = Modifier) {
    val text = NumberFormat.getNumberInstance().format(distance).run {
        when {
            1000.0 > distance ->
                stringResource(R.string.unit_meter, this)
            else ->
                stringResource(R.string.unit_kilo_meter, this)
        }
    }
    Text(text = text, modifier = modifier)
}

@Composable
@Preview(showBackground = true)
fun Preview_Distance_Meter() {
    ParkingTheme {
        Distance(distance = 123.0)
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_Distance_Kilometer() {
    ParkingTheme {
        Distance(distance = 123_456.7)
    }
}
