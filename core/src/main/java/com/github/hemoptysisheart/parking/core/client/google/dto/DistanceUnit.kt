package com.github.hemoptysisheart.parking.core.client.google.dto

enum class DistanceUnit(
    val code: String
) {
    /**
     * `metric` specifies usage of the metric system. Textual distances are returned using kilometers and meters.
     */
    METRIC("metric"),

    /**
     * `imperial` specifies usage of the Imperial (English) system. Textual distances are returned using miles and feet.
     */
    IMPERIAL("imperial");

    companion object {
        private val CODE_MAP = values().associateBy { it.code }

        operator fun get(code: String) = CODE_MAP[code]!!

        operator fun get(ordinal: Int) = values()[ordinal]
    }
}
