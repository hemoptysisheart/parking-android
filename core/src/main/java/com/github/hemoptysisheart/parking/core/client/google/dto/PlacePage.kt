package com.github.hemoptysisheart.parking.core.client.google.dto

/**
 * 장소 페이지.
 */
class PlacePage(
    /**
     * 장소 목록.
     */
    val places: List<PlaceDto>,
    /**
     * 다음 페이지 반환.
     */
    val next: (suspend () -> PlacePage)?
) {
    val hasNext = null != next

    override fun toString() = "${PlacePage::class.simpleName}(places=$places, hasNext=$hasNext)"
}