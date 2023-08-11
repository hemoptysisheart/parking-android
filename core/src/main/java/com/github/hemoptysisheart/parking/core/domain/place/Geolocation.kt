package com.github.hemoptysisheart.parking.core.domain.place

import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.google.android.gms.maps.model.LatLng

fun Geolocation.toLatLng() = LatLng(latitude, longitude)
