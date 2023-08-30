package com.github.hemoptysisheart.parking.app.ui.resource

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.github.hemoptysisheart.parking.app.ui.resource.TransportationRes.DRIVING
import com.github.hemoptysisheart.parking.app.ui.resource.TransportationRes.WALKING
import com.github.hemoptysisheart.parking.core.R.string.domain_transport_drive
import com.github.hemoptysisheart.parking.core.R.string.domain_transport_walk
import com.github.hemoptysisheart.parking.domain.route.Transportation

enum class TransportationRes(
        val transportation: Transportation,
        @StringRes val label: Int,
        val icon: ImageVector
) {
    DRIVING(
            Transportation.DRIVING,
            domain_transport_drive,
            Icons.Default.DirectionsCar
    ),
    WALKING(
            Transportation.WALKING,
            domain_transport_walk,
            Icons.Default.DirectionsWalk
    );

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)

        operator fun get(transportation: Transportation) = values().first { transportation == it.transportation }
    }
}

@Composable
internal fun TransportationRes.color(): Color = when (this) {
    DRIVING -> MaterialTheme.colorScheme.onPrimaryContainer
    WALKING -> MaterialTheme.colorScheme.onSecondaryContainer
}

@Composable
internal fun TransportationRes.backgroundColor(): Color = when (this) {
    DRIVING -> MaterialTheme.colorScheme.primaryContainer
    WALKING -> MaterialTheme.colorScheme.secondaryContainer
}
