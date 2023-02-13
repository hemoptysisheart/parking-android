package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.model.dto.PlaceSearchResult
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location

interface PlaceModel {
    /**
     * `center`를 중심으로 장소를 검색한다.
     */
    suspend fun searchDestination(center: GeoLocation, query: String): PlaceSearchResult

    /**
     * 해당 지역을 중심으로 주차장 찾기.
     */
    suspend fun searchParking(location: Location): PlaceSearchResult
}