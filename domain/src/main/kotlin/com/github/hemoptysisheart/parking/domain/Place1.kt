package com.github.hemoptysisheart.parking.domain

import com.github.hemoptysisheart.util.Savable
import java.util.*

/**
 * 어떤 장소
 */
interface Place1 : Savable {
    val id: UUID

    val level: PlaceLevel

    val location: Location

    /**
     * 목록처럼 어려 어떤 장소를 표시할 때 대표 정보로 사용.
     */
    var name: String

    var description: String
}