package com.github.hemoptysisheart.parking.core.model.dto

import com.github.hemoptysisheart.parking.domain.Location
import com.google.maps.model.LatLng

/**
 * [LatLng] 래퍼.
 */
class LocationMapsLatLng(
    val latLng: LatLng
) : Location {
    override val id = "${latLng.lat},${latLng.lng}"

    override val name = id

    override val description: String? = null

    override val latitude = latLng.lat

    override val longitude = latLng.lng

    override fun equals(other: Any?) = this === other ||
            (null != other && other is LocationMapsLatLng && id == other.id)

    override fun hashCode() = id.hashCode()

    override fun toString() = id
}