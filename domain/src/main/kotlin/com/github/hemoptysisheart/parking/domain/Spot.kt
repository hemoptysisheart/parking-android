package com.github.hemoptysisheart.parking.domain

/**
 * 장소
 */
interface Spot : Place {
    override val level: PlaceLevel
        get() = PlaceLevel.SPOT

    /**
     * 상세 주소
     */
    val detailAddress: String

    /**
     * 해당하는 대략적 장소.
     */
    val coarseSpot: CoarseSpot

    /**
     * 해당하는 자세한 장소.
     */
    val fineSpots: List<FineSpot>

    /**
     * [Google Places ID](https://developers.google.com/maps/documentation/places/android-sdk/place-id#id-overview)
     */
    var placesId: String?
}