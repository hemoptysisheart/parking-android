package com.github.hemoptysisheart.parking.core.client.google.dto

enum class GeocoderStatus {
    OK,
    ZERO_RESULTS;

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]
    }
}
