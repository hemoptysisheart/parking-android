package com.github.hemoptysisheart.parking.domain.common

import java.net.URLEncoder
import java.nio.charset.StandardCharsets.UTF_8

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

    override fun toString() = URLEncoder.encode("$SCHEME:$type/$key", UTF_8)!!
}