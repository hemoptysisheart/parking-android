package com.github.hemoptysisheart.parking.app.ui.component.map

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.preview.domain.PlaceData
import com.github.hemoptysisheart.parking.domain.Place
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun PlaceViewSimple(place: Place?) {
    Row(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(20.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp))
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (null == place) {
            Icon(Icons.Default.Search, stringResource(R.string.map_place_view_simple_description))
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = stringResource(R.string.map_place_view_simple_placeholder),
                modifier = Modifier.weight(1.0F),
                color = Color.Gray
            )
        } else {
            Icon(Icons.Default.LocationOn, place.name)
            Spacer(modifier = Modifier.width(3.dp))
            Text(place.name, Modifier.weight(1.0F))
        }
    }
}

@Composable
@Preview
fun PlaceViewSimplePreviewNull() {
    ParkingTheme {
        PlaceViewSimple(null)
    }
}

@Composable
@Preview
fun PlaceViewSimplePreviewDummy() {
    ParkingTheme {
        PlaceViewSimple(PlaceData.PLACE)
    }
}
