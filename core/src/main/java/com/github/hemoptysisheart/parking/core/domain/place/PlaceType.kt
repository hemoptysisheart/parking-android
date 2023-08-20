package com.github.hemoptysisheart.parking.core.domain.place

import com.github.hemoptysisheart.parking.client.google.data.PlaceTypeResultOnly
import com.github.hemoptysisheart.parking.client.google.data.PlaceTypes
import com.github.hemoptysisheart.parking.domain.place.PlaceType

fun PlaceType.toGmp(): com.github.hemoptysisheart.parking.client.google.data.PlaceType? = when (this) {
    PlaceType.UNSPECIFIED -> null
    PlaceType.DESTINATION -> PlaceTypeResultOnly.POINT_OF_INTEREST
    PlaceType.PARKING -> PlaceTypes.PARKING
}
