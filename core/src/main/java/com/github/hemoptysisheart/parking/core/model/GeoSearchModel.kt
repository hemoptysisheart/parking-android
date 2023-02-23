package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.model.dto.PlaceSearchResult
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location
import com.google.maps.model.TravelMode
import com.google.maps.model.TravelMode.DRIVING

interface GeoSearchModel {
    /**
     * `center`를 중심으로 장소를 검색한다.
     */
    suspend fun searchDestination(center: GeoLocation, query: String): PlaceSearchResult

    /**
     * 목적지 주변 주차장 찾기.
     *
     * @param destination 목적지.
     */
    suspend fun searchParking(destination: Location): PlaceSearchResult

    /**
     * 출발지에서 목적지 까지의 경로를 검색한다.
     *
     * @param origin 출발지
     * @param destination 목적지
     * @param mode 이동 수단
     */
    suspend fun searchPath(origin: Location, destination: Location, mode: TravelMode = DRIVING): List<Location>
}