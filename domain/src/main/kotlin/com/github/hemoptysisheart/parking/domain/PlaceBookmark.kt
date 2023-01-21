package com.github.hemoptysisheart.parking.domain

import com.github.hemoptysisheart.util.Savable
import java.util.*

/**
 * 즐겨찾기
 */
interface PlaceBookmark : Savable {
    /**
     * ID
     */
    val id: UUID

    /**
     * 즐겨찾기 대상인 어떤 장소.
     */
    val place: Place1

    /**
     * 요약 정보.
     *
     * 목록처럼 어려 즐겨찾기를 표시할 때 대표 정보로 사용.
     */
    val summary: String

    val memo: String
}