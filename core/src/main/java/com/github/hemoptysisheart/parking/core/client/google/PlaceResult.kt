package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.data.Place
import com.github.hemoptysisheart.parking.core.client.google.data.PlacesDetailsStatus

data class PlaceResult(
    val htmlAttributes: List<String>,
    val place: Place,
    val status: PlacesDetailsStatus,
    val infoMessages: List<String>?
)
