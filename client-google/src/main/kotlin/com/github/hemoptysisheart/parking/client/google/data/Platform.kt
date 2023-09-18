package com.github.hemoptysisheart.parking.client.google.data

enum class Platform {
    ANDROID,
    IOS,
    WEB;

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)
    }
}
