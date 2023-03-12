package com.github.hemoptysisheart.parking.core.extension

import com.github.hemoptysisheart.parking.domain.Overview
import com.google.android.gms.maps.model.LatLng

val Overview.points: List<LatLng>
    get() = locations.map { it.latLng }
