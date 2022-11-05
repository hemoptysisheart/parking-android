package com.github.hemoptysisheart.parking.domain

/**
 * 어떤 장소의 계층.
 */
enum class PlaceLevel(
    val level: Int,
    val label: String
) {
    COARSE_SPOT(0, "대략적 장소"),
    SPOT(1, "장소"),
    FINE_SPOT(2, "자세한 장소");
}