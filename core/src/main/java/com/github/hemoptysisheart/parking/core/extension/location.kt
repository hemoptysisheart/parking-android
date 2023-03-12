package com.github.hemoptysisheart.parking.core.extension

import com.github.hemoptysisheart.parking.domain.Location
import com.google.android.gms.maps.model.LatLng

val Location.latLng: LatLng
    get() = LatLng(latitude, longitude)