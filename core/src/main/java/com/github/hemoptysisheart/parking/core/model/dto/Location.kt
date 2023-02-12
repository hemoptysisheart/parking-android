package com.github.hemoptysisheart.parking.core.model.dto

import com.github.hemoptysisheart.parking.domain.Location
import com.google.android.gms.maps.model.LatLng

fun Location.toLatLng() = LatLng(latitude, longitude)