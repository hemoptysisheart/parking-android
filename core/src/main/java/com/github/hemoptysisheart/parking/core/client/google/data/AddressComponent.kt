package com.github.hemoptysisheart.parking.core.client.google.data

data class AddressComponent(
    val longName: String,
    val shortName: String,
    val types: Set<PlaceType>
)
