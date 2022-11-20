package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.Location
import java.time.Instant

interface LocationModel {
    interface UpdateCallback {
        fun onUpdate(location: Location)
    }

    val current: Location

    suspend fun update(src: android.location.Location, timestamp: Instant): Location

    /**
     * 위치정보가 갱신됐을 때 새 위치 정보를 받을 수 있는 콜백을 등록한다.
     */
    fun addCallback(callback: UpdateCallback)

    /**
     * 콜백을 제거한다.
     *
     * @return 성공하면 `true`.
     */
    fun removeCallback(callback: UpdateCallback): Boolean
}