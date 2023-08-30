package com.github.hemoptysisheart.parking.core.domain.route

import com.github.hemoptysisheart.parking.client.google.data.LatLng
import com.github.hemoptysisheart.parking.client.google.data.LatLngDescriptor
import com.github.hemoptysisheart.parking.client.google.data.PlaceIdDescriptor
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.route.Waypoint

fun Waypoint.toPlaceDescriptor() = when (this) {
    is Geolocation ->
        LatLngDescriptor(LatLng(latitude, longitude))

    is Place ->
        PlaceIdDescriptor(id.key)

    else ->
        throw UnsupportedOperationException("unsupported waypoint type : type=${this::class}")
}
