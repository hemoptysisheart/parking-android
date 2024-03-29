package com.github.hemoptysisheart.parking.client.google.data

enum class BusinessStatus {
    OPERATIONAL,
    CLOSED_TEMPORARILY,
    CLOSED_PERMANENTLY;

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)
    }
}