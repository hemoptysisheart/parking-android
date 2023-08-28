package com.github.hemoptysisheart.parking.core.domain.route

import com.github.hemoptysisheart.parking.client.google.data.TransportationMode
import com.github.hemoptysisheart.parking.domain.route.Transportation

val Transportation.mode: TransportationMode
    get() = when (this) {
        Transportation.DRIVING ->
            TransportationMode.DRIVING

        Transportation.WALKING ->
            TransportationMode.WALKING

        else ->
            throw UnsupportedOperationException("unsupported transportation : $this")
    }