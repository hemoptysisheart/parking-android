package com.github.hemoptysisheart.parking.core.domain.place

import com.github.hemoptysisheart.parking.core.domain.common.AbstractObject
import com.github.hemoptysisheart.parking.core.domain.common.Types.PLACE_GMP
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place

/**
 * Google Maps Platform - Places API 장소 데이터
 */
class PlaceGooglePlace(
        key: String,
        override val name: String,
        override val address: String,
        override val geolocation: Geolocation
) : AbstractObject(Identifier(PLACE_GMP, key)), Place {
    override fun toSimpleString() = "($id, $name)"

    override fun toString() =
            "PlaceGooglePlace(id=$id, name='$name', address='$address', geolocation=${geolocation.toSimpleString()})"
}
