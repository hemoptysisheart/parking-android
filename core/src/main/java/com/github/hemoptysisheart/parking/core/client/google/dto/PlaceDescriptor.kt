package com.github.hemoptysisheart.parking.core.client.google.dto

import com.github.hemoptysisheart.parking.domain.GeoLocation

/**
 * 장소
 */
data class PlaceDescriptor(
    val placeId: String? = null,
    val geoLocation: GeoLocation? = null,
    val address: String? = null
) {
    init {
        when {
            placeId.isNullOrEmpty() && null == geoLocation && address.isNullOrEmpty() ->
                throw IllegalArgumentException("all properties are null or empty.")
        }
    }

    @Suppress("KotlinConstantConditions")
    override fun toString() = when {
        !placeId.isNullOrEmpty() ->
            "place_id:$placeId"
        null != geoLocation ->
            geoLocation.toSimpleString()
        !address.isNullOrEmpty() ->
            address
        else ->
            throw IllegalStateException("illegal status : placeId=$placeId, geoLocation=$geoLocation, address=$address")
    }
}
