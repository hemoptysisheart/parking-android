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
                lightColorScheme(
                        primary = LightPrimary,
                        onPrimary = LightOnPrimary,
                        primaryContainer = LightPrimaryContainer,
                        onPrimaryContainer = LightOnPrimaryContainer,
                        inversePrimary = LightInversePrimary,
                        secondary = LightSecondary,
                        onSecondary = LightOnSecondary,
                        secondaryContainer = LightSecondaryContainer,
                        onSecondaryContainer = LightOnSecondaryContainer,
                        tertiary = LightTertiary,
                        onTertiary = LightOnTertiary,
                        tertiaryContainer = LightTertiaryContainer,
                        onTertiaryContainer = LightOnTertiaryContainer,
                        background = LightBackground,
                        onBackground = LightOnBackground,
                        surface = LightSurface,
                        onSurface = LightOnSurface,
                        surfaceVariant = LightSurfaceVariant,
                        onSurfaceVariant = LightOnSurfaceVariant,
                        surfaceTint = LightSurfaceTint,
                        inverseSurface = LightInverseSurface,
                        inverseOnSurface = LightInverseOnSurface,
                        error = LightError,
                        errorContainer = LightErrorContainer,
                        onError = LightOnError,
                        onErrorContainer = LightOnErrorContainer,
                        outline = LightOutline,
                        outlineVariant = LightOutlineVariant,
                        scrim = LightScrim
                )
            } else {
                darkColorScheme(
                        primary = DarkPrimary,
                        onPrimary = DarkOnPrimary,
                        primaryContainer = DarkPrimaryContainer,
                        onPrimaryContainer = DarkOnPrimaryContainer,
                        inversePrimary = DarkInversePrimary,
                        secondary = DarkSecondary,
                        onSecondary = DarkOnSecondary,
                        secondaryContainer = DarkSecondaryContainer,
                        onSecondaryContainer = DarkOnSecondaryContainer,
                        tertiary = DarkTertiary,
                        onTertiary = DarkOnTertiary,
                        tertiaryContainer = DarkTertiaryContainer,
                        onTertiaryContainer = DarkOnTertiaryContainer,
                        background = DarkBackground,
                        onBackground = DarkOnBackground,
                        surface = DarkSurface,
                        onSurface = DarkOnSurface,
                        surfaceVariant = DarkSurfaceVariant,
                        onSurfaceVariant = DarkOnSurfaceVariant,
                        surfaceTint = DarkSurfaceTint,
                        inverseSurface = DarkInverseSurface,
                        inverseOnSurface = DarkInverseOnSurface,
                        error = DarkError,
                        errorContainer = DarkErrorContainer,
                        onError = DarkOnError,
                        onErrorContainer = DarkOnErrorContainer,
                        outline = DarkOutline,
                        outlineVariant = DarkOutlineVariant,
                        scrim = DarkScrim
                )
            },
            typography = Typography,
            shapes = Shapes,
            content = content
    )
}
