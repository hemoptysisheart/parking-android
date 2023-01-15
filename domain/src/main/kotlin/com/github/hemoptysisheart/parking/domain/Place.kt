package com.github.hemoptysisheart.parking.domain

/**
 * 어떤 장소에 관한 정보.
 */
interface Place {
    /**
     * 종류
     */
    val type: PlaceType

    /**
     * 장소 ID.
     */
    val id: String

    /**
     * 장소 이름.
     */
    val name: String

    /**
     * 장소 설명.
     * 기본 `null`.
     */
    val description: String?

    /**
     * 좌표. 알려지지 않았거나 대표할 수 있는 좌표가 없는 경우엔 `null`.
     */
    val coordinate: Coordinate?
}