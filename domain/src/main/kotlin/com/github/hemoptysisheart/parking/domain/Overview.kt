package com.github.hemoptysisheart.parking.domain

/**
 * 좌표를 연결해 대략적인 경로를 나타낸다.
 */
data class Overview(
    val locations: List<GeoLocation>
)
