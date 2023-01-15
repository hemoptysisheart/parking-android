package com.github.hemoptysisheart.parking.domain

/**
 * 위도 경도 장소.
 */
class CoordinatePlace(
    override val coordinate: Coordinate
) : Place {
    constructor(latitude: Double, longitude: Double) : this(Coordinate(latitude, longitude))

    override val type: PlaceType = PlaceType.COORDINATE

    override val id: String = "$coordinate"

    override val name: String = id

    override val description: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        return coordinate == (other as CoordinatePlace).coordinate
    }

    override fun hashCode() = coordinate.hashCode()

    override fun toString() = "$coordinate"
}