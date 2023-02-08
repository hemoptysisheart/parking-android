package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.model.dto.PlaceSearchResult
import com.github.hemoptysisheart.parking.domain.GeoLocation

interface PlaceModel {
    /**
     * `center`를 중심으로 장소를 검색한다.
     */
    suspend fun search(center: GeoLocation, query: String): PlaceSearchResult
}