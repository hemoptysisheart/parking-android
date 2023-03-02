package com.github.hemoptysisheart.parking.core.client.google.dto

data class PlacePhoto(
    val width: Int,
    val height: Int,
    val htmlAttributions: List<String>,
    val photoReference: String
)
