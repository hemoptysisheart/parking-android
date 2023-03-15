package com.github.hemoptysisheart.parking.core.extension

import com.github.hemoptysisheart.parking.domain.GeoLocation

val com.github.hemoptysisheart.parking.core.client.google.dto.LatLng.location: GeoLocation
    get() = GeoLocation(latitude, longitude)

val com.google.android.gms.maps.model.LatLng.location: GeoLocation
    get() = GeoLocation(latitude, longitude)
