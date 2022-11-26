package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.model.param.MapStateParams
import com.google.android.gms.maps.model.LatLng

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
    val center: LatLng

    /**
     * 확대 수준.
     */
    val zoom: Float

    /**
     * 지도 상태 변경.
     */
    suspend fun update(state: MapStateParams)
}