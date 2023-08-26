package com.github.hemoptysisheart.parking.app.ui.template.selectparking

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_PALACE_BLDG_PARKING_LOT
import com.github.hemoptysisheart.parking.app.ui.template.LOGGER
import com.github.hemoptysisheart.parking.domain.place.Place

/**
 * 목적지 주변 주차장.
 */
@Composable
fun ParkingListItem(parking: Place, onClickSelectRoute: (Place) -> Unit = { }) {
    LOGGER.v("#ParkingListItem args : parking=$parking")

    Row {
        Column(modifier = Modifier.weight(1F)) {
            TextLabelMedium(
                    text = parking.name,
                    modifier = Modifier.padding(0.dp, 5.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
            )
            TextBodyMedium(
                    text = parking.address,
                    modifier = Modifier.padding(0.dp, 5.dp),
                    color = MaterialTheme.colorScheme.onBackground
            )
            TextBodyMedium(
                    text = parking.geolocation.toSimpleString(),
                    modifier = Modifier.padding(0.dp, 5.dp),
                    color = MaterialTheme.colorScheme.outline
            )
        }
        IconButton(onClick = { onClickSelectRoute(parking) }) {
            Icon(
                    imageVector = Icons.Default.Directions,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}


@Composable
@ComponentPreview
fun Preview_ParkingListItem() {
    ComponentPreviewContainer {
        ParkingListItem(PLACE_PALACE_BLDG_PARKING_LOT)
    }
}
