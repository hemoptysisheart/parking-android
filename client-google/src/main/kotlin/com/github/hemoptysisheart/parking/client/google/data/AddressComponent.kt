package com.github.hemoptysisheart.parking.client.google.data

data class AddressComponent(
        val longName: String,
        val shortName: String,
        val types: Set<PlaceType>
)
