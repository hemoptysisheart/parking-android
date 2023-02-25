package com.github.hemoptysisheart.parking.domain

data class Route(
    val origin: Location,
    val parking: Location,
    val destination: Location
) {
    companion object {
        private const val TAG = "Route"
    }
}
