package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.Location

interface LocationModel {
    suspend fun update(src: android.location.Location): Location
}