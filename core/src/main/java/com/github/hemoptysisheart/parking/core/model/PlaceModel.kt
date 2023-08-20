package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.search.Query

/**
 * [Place]에 관련된 기능을 제공한다.
 */
interface PlaceModel {
    /**
     * 장소를 찾는다. 없으면 `null`
     */
    suspend fun read(id: Identifier): Place?

    /**
     * 목적지 검색하기. 검색 결과가 없으면 빈 배열.
     */
    suspend fun searchDestination(query: Query): List<Place>
}