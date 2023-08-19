package com.github.hemoptysisheart.parking.core.domain.place

import com.github.hemoptysisheart.parking.domain.place.Geolocation

fun com.github.hemoptysisheart.parking.domain.place.Place.toLatLng() = geolocation.toLatLng()

fun com.github.hemoptysisheart.parking.client.google.data.Place.toDomain(): PlaceGooglePlace {
    val source = listOfNotNull(
            name,
            formattedAddress,
            vicinity,
            plusCode?.compoundCode,
            placeId
    ).filter { it.isNotEmpty() }

    return PlaceGooglePlace(
            key = placeId ?: throw IllegalArgumentException("placeId is null."),
            name = source[0],
            address = source[1],
            geolocation = Geolocation(geometry!!.location.latitude, geometry!!.location.longitude)
    )
}
