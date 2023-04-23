package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.client.google.data.TransportationMode
import com.github.hemoptysisheart.parking.core.model.data.PlaceSearchResult
import com.github.hemoptysisheart.parking.core.model.data.RouteSearchResult
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItemLocation
import com.github.hemoptysisheart.parking.domain.Route
import java.util.*

interface LocationModel {
    /**
     * `center`를 중심으로 장소를 검색한다.
     *
     * TODO 검색 결과는 [Location]을 사용하도록 변경. [RecommendItemLocation]는 UI 레이어에서 처리하도록 변경.
     */
    suspend fun searchDestination(center: GeoLocation, query: String): PlaceSearchResult

    /**
     * @return 없으면 `null`.
     */
    suspend fun read(id: String): Location?

    /**
     * 목적지 주변 주차장 찾기.
     *
     * TODO 검색 결과는 [Location]을 사용하도록 변경. [RecommendItemLocation]는 UI 레이어에서 처리하도록 변경.
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
    suspend fun searchRoute(origin: Location, destination: Location, mode: TransportationMode): RouteSearchResult

    suspend fun searchRoute(origin: Location, destination: Location): List<Route>

    suspend fun read(id: UUID): Route?
}
