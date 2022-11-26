package com.github.hemoptysisheart.parking.core.repository

import com.github.hemoptysisheart.parking.domain.MapState

/**
 * [MapState] 데이터 관리.
 */
interface MapStateRepository {
    /**
     * @param state 저장 전 엔티티.
     * @return 저장된 엔티티.
     */
    suspend fun create(state: MapState): MapState
}