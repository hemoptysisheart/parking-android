package com.github.hemoptysisheart.parking.domain.search

import com.github.hemoptysisheart.parking.domain.place.Place

/**
 * 추천 장소.
 */
interface RecommendItemPlace : RecommendItem<Place> {
    override val item: Place
        get() = place

    /**
     * 추천 장소.
     */
    val place: Place
}