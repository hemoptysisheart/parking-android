package com.github.hemoptysisheart.parking.domain

/**
 * 자세한 장소
 */
interface FineSpot : Place1 {
    override val level: PlaceLevel
        get() = PlaceLevel.FINE_SPOT

    /**
     * 장소
     */
    val spot: Spot
}