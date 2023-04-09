package com.github.hemoptysisheart.parking.domain

/**
 * 목적지까지 경로.
 *
 * TODO 경로 타입 정리.
 */
data class Route(
    /**
     * 출발지(현재위치).
     */
    val origin: Location,

    /**
     * 주차장.
     */
    val parking: Location,

    /**
     * 목적지.
     */
    val destination: Location

) {
    /**
     * 출발지에서 주차장까지 운전경로.
     */
    var driving: PartialRoute? = null

    /**
     * 주차장에서 목적지까지 걷는 경로.
     */
    var walking: PartialRoute? = null

    var distance: Double? = null
        get() = if (null == driving && null == walking) {
            null
        } else {
            driving!!.distance!! + walking!!.distance!!
        }
        private set

    override fun equals(other: Any?) = this === other ||
            javaClass == other?.javaClass &&
            other is Route &&
            origin == other.origin &&
            parking == other.parking &&
            destination == other.destination &&
            driving == other.driving &&
            walking == other.walking

    override fun hashCode(): Int {
        var result = origin.hashCode()
        result = 31 * result + parking.hashCode()
        result = 31 * result + destination.hashCode()
        result = 31 * result + driving.hashCode()
        result = 31 * result + walking.hashCode()
        return result
    }

    override fun toString() =
        "Route(origin=$origin, parking=$parking, destination=$destination, driving=$driving, walking=$walking)"
}
