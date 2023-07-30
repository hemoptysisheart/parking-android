package com.github.hemoptysisheart.parking.client.google.data

enum class ReviewSort(
    val code: String
) {
    MOST_RELEVANT("most_relevant"),
    NEWEST("newest");

    companion object {
        private val CODE_MAP = values().associateBy { it.code }

        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(code: String) = CODE_MAP[code]!!
    }
}
