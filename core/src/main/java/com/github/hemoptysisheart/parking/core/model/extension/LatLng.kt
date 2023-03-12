package com.github.hemoptysisheart.parking.core.model.extension

import com.github.hemoptysisheart.parking.core.client.google.dto.LatLng

val LatLng.latLng: com.google.android.gms.maps.model.LatLng
    get() = com.google.android.gms.maps.model.LatLng(latitude, longitude)