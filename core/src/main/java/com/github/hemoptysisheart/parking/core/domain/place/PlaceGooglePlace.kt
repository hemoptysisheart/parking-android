package com.github.hemoptysisheart.parking.core.domain.place

import com.github.hemoptysisheart.parking.core.domain.common.Types.PLACE_GMP
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place

/**
 * Google Maps Platform - Places API 장소 데이터
 */
class PlaceGooglePlace(
        place: com.github.hemoptysisheart.parking.client.google.data.Place
) : Place {
    override val id = Identifier(PLACE_GMP, place.placeId ?: throw IllegalArgumentException("placeId is null."))

    override val name: String

    override val address: String

    override val geolocation: Geolocation = place.geometry?.toGeolocation()
            ?: throw IllegalArgumentException("geometry is null.")

    init {
        listOfNotNull(place.name, place.formattedAddress, place.placeId).let {
            name = it[0]
            address = it[1]
        }
    }

    override fun toSimpleString() = "($id, $name, $address)"

    override fun toString() = "PlaceGooglePlace(id=$id, name='$name', address='$address', geolocation=$geolocation)"
}