package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.GeoLocation

/**
 * 단말기 센서에서 습득한 정보를 제공.
 */
interface SensorModel {
    /**
     * 최신 현재 위치.
     */
    val location: GeoLocation

    /**
     * 위치가 바뀔 경우 콜백 등록.
     */
    fun addLocationCallback(key: Any, callback: (GeoLocation) -> Unit)

    /**
     * 콜백 제거.
     */
    fun removeLocationCallback(key: Any)
}
