package com.github.hemoptysisheart.parking.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun ParkingTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (darkTheme) {
            lightColorScheme()
        } else {
            darkColorScheme()
        },
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
