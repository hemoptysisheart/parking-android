package com.github.hemoptysisheart.parking.domain

/**
 * 장소를 검색 기록을 장소와 같은 방식으로 다루기 위한 클래스.
 */
class QueryPlace(
    val query: String,
    override val coordinate: Coordinate
) : Place {
    override val type: PlaceType = PlaceType.QUERY

    override val id: String = toString()

    override val name: String = query

    override val description: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        return query == (other as QueryPlace).query
    }

    override fun hashCode() = query.hashCode()

    override fun toString() = "$query@$coordinate"
}