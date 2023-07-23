package com.github.hemoptysisheart.parking.core.extension

import com.github.hemoptysisheart.parking.domain.deprecate.GeoLocation

val com.github.hemoptysisheart.parking.core.client.google.data.LatLng.location: GeoLocation
    get() = GeoLocation(latitude, longitude)

val com.google.android.gms.maps.model.LatLng.location: GeoLocation
    get() = GeoLocation(latitude, longitude)
