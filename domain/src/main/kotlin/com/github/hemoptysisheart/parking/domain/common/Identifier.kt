package com.github.hemoptysisheart.parking.domain.common

import java.net.URI

data class Identifier(
        val type: Type,
        val key: String
) {
    companion object {
        const val SCHEME = "parking"
    }

    fun toURI() = URI(SCHEME, "$type", "/$key", null)

    override fun toString() = toURI().toString()
}
