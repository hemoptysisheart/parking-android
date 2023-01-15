package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.Coordinate

/**
 * 위치정보 모델.
 */
interface LocationModel {
    /**
     * 최신 위치.
     */
    val location: Coordinate

    suspend fun update(src: android.location.Location): Coordinate
}