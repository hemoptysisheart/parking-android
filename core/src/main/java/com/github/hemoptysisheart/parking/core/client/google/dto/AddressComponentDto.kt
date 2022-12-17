package com.github.hemoptysisheart.parking.core.client.google.dto

data class AddressComponentDto(
    val longName: String,
    val shortName: String,
    val types: Set<PlaceType>
)
