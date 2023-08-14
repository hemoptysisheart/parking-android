package com.github.hemoptysisheart.parking.domain.common

data class Identifier(
        val type: Type,
        val key: String
) {
    companion object {
        const val SCHEME = "parking"
    }

    init {
        if (key.isEmpty()) {
            throw IllegalArgumentException("key is empty.")
        }
    }

    override fun toString() = "$SCHEME:$type/$key"
}
