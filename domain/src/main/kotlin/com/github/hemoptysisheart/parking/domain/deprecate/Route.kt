package com.github.hemoptysisheart.parking.domain.deprecate

import java.util.*

/**
 * 목적지까지 경로.
 *
 * TODO 경로 타입 정리.
 */
data class Route(
    val id: UUID,
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
        get() = if (null != driving && null != walking) {
            driving!!.distance!! + walking!!.distance!!
        } else {
            null
        }
        private set

    fun contains(here: Location): Boolean {
        // TODO 현재 위치가 경로에 포함되는지 아닌지 검사하기.
        return true
    }

    override fun equals(other: Any?) = this === other ||
            javaClass == other?.javaClass &&
            other is Route &&
            id == other.id

    override fun hashCode() = id.hashCode()

    override fun toString() =
        "Route(id=$id, origin=$origin, parking=$parking, destination=$destination, driving=$driving, walking=$walking, distance=$distance)"
}
