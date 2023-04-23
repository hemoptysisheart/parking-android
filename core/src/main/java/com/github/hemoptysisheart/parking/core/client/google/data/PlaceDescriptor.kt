package com.github.hemoptysisheart.parking.core.client.google.data

/**
 * 장소
 */
sealed interface PlaceDescriptor

class PlaceIdDescriptor(
    val placeId: String
) : PlaceDescriptor {
    init {
        when {
            placeId.isEmpty() ->
                throw IllegalArgumentException("placeId is empty.")
        }
    }

    override fun toString() = "place_id:$placeId"
}

@Suppress("MemberVisibilityCanBePrivate")
class LatLngDescriptor(
    val latLng: LatLng
) : PlaceDescriptor {
    override fun toString() = "$latLng"
}

class AddressDescriptor(
    val address: String
) : PlaceDescriptor {
    init {
        when {
            address.isEmpty() ->
                throw IllegalArgumentException("address is empty.")
        }
    }

    override fun toString() = address
}
