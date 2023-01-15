package com.github.hemoptysisheart.parking.domain

enum class PlaceType {
    /**
     * 장소를 검색하기 위한 검색어.
     */
    QUERY,

    /**
     * 위도, 경도 좌표.
     */
    COORDINATE,

    /**
     * Google Places API 검색 결과.
     */
    GOOGLE;
}
