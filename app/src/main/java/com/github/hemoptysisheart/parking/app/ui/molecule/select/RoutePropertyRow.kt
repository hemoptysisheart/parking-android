package com.github.hemoptysisheart.parking.app.ui.molecule.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.ui.theme.TextDefault
import com.github.hemoptysisheart.parking.app.ui.theme.TextNull

@Composable
fun RoutePropertyRow(
    name: String,
    value: Any?,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(text = name, modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(10.dp))
        val color = if (null == value) {
            TextNull
        } else {
            TextDefault
        }
        Text(text = "$value", modifier = Modifier.weight(2f), color = color)
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_RoutePropertyRow_null() {
    ParkingTheme {
        RoutePropertyRow("null", null)
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_RoutePropertyRow_text() {
    ParkingTheme {
        RoutePropertyRow("text", "text value")
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_RoutePropertyRow_int() {
    ParkingTheme {
        RoutePropertyRow("int", 123)
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_RoutePropertyRow_double() {
    ParkingTheme {
        RoutePropertyRow("double", 123456.7)
    }
}
