package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.Location
import java.time.Instant

interface LocationModel {
    suspend fun update(src: android.location.Location, timestamp: Instant): Location
}