package com.github.hemoptysisheart.parking.app.viewmodel

import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.google.android.gms.maps.model.LatLng

fun GeoLocation.toLatLng() = LatLng(latitude, longitude)
