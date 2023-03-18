package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.GeoLocation

/**
 * 위치 정보 제공.
 */
interface LocationModel {
    /**
     * 최신 현재 위치.
     */
    val location: GeoLocation

    /**
     * 위치가 바뀔 경우 콜백 등록.
     */
    fun addCallback(key: Any, callback: (GeoLocation) -> Unit)

    /**
     * 콜백 제거.
     */
    fun removeCallback(key: Any)
}
