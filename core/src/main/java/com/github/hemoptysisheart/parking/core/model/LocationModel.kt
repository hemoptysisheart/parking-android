package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.place.Geolocation

/**
 * 위치정보 모델.
 */
interface LocationModel {
    /**
     * 위치정보 권한이 있으면 `true`.
     */
    val granted: Boolean

    /**
     * 현재 위치. 위치정보 권한이 없으면 `null`.
     */
    val location: Geolocation?

    /**
     * [LocationModel] 재설정.
     */
    fun reset()
}
