package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.Location
import java.time.Instant

/**
 * 위치정보 모델.
 */
interface LocationModel {
    /**
     * 최신 위치.
     */
    val location: Location

    suspend fun update(src: android.location.Location, timestamp: Instant): Location
}