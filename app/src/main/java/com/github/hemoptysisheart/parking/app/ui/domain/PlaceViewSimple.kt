package com.github.hemoptysisheart.parking.app.ui.domain

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.github.hemoptysisheart.parking.app.ui.config.LogicConstants
import com.github.hemoptysisheart.parking.app.ui.preview.domain.PlaceData
import com.github.hemoptysisheart.parking.domain.Place
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun PlaceViewSimple(place: Place?) {
    Row(
        Modifier
            .clickable {
                Log.v(LogicConstants.TAG_COMPOSE, "#MapHeader place clicked.")
            }
            .background(Color.White, RoundedCornerShape(20.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp))
            .padding(5.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (null == place) {
            Icon(Icons.Default.Search, stringResource(R.string.map_place_view_simple_description))
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = stringResource(R.string.map_place_view_simple_placeholder),
                color = Color.Gray
            )
        } else {
            Icon(Icons.Default.LocationOn, place.name)
            Spacer(modifier = Modifier.width(3.dp))
            Text(place.name)
        }
    }
}

@Composable
@Preview
fun PlaceViewSimplePlaceNull() {
    ParkingTheme {
        PlaceViewSimple(null)
    }
}

@Composable
@Preview
fun PlaceViewSimplePlaceData() {
    ParkingTheme {
        PlaceViewSimple(PlaceData.PLACE)
    }
}