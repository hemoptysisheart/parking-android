package com.github.hemoptysisheart.parking.core.client.google.data

import java.time.Duration
import java.time.Instant

class ResultMeta<P>(
    val params: P,
    val requestAt: Instant,
    val responseAt: Instant
) {
    val duration: Duration = Duration.between(requestAt, responseAt)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ResultMeta<*>

        return params == other.params &&
                requestAt == other.requestAt &&
                responseAt == other.responseAt
    }

    override fun hashCode(): Int {
        var result = params?.hashCode() ?: 0
        result = 31 * result + requestAt.hashCode()
        result = 31 * result + responseAt.hashCode()
        return result
    }

    override fun toString() =
        "${ResultMeta::class.simpleName}(params=$params, requestAt=$requestAt, responseAt=$responseAt, duration=$duration)"
}
