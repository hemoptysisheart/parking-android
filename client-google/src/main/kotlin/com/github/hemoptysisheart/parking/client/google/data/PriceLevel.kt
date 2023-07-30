package com.github.hemoptysisheart.parking.client.google.data

enum class PriceLevel(
    val code: Int
) {
    FREE(0),
    INEXPENSIVE(1),
    MODERATE(2),
    EXPENSIVE(3),
    VERY_EXPENSIVE(4);

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]
    }
}
