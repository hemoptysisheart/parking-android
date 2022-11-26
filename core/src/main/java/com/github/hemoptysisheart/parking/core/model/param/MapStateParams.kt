package com.github.hemoptysisheart.parking.core.model.param

import com.google.android.gms.maps.model.LatLng
import java.time.Instant

data class MapStateParams(
    /**
     * 지도 중심 위치.
     */
    val center: LatLng,

    /**
     * 지도 확대 수준.
     */
    val zoom: Float,

    /**
     * 지도 상태 확인 시각.
     */
    val timestamp: Instant
)
