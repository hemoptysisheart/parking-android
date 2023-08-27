package com.github.hemoptysisheart.parking.domain.place

enum class PlaceType {
    UNSPECIFIED,
    DESTINATION,
    PARKING;

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)
    }
}
