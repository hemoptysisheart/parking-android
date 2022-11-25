package com.github.hemoptysisheart.parking.core.model

import com.google.android.gms.maps.model.LatLng
import java.time.Instant

/**
 * 지도의 데이터를 모델.
 */
interface MapModel {
    companion object {
        const val ZOOM_DEFAULT = 17.0F
    }

    /**
     * 중심 좌표.
     */
    suspend fun getCenter(): LatLng

    /**
     * 중심 좌표.
     */
    suspend fun setCenter(center: LatLng, timestamp: Instant = Instant.now())

    /**
     * 확대 수준.
     */
    suspend fun getZoom(): Float

    /**
     * 확대 수준.
     */
    suspend fun setZoom(zoom: Float, timestamp: Instant = Instant.now())
}