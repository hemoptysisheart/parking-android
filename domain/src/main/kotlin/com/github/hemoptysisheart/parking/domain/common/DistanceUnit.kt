package com.github.hemoptysisheart.parking.domain.common

enum class DistanceUnit(
        val label: String,
        /**
         * meter per unit
         */
        val mpu: Int
) {
    METER("m", 1),
    KILOMETER("Km", 1_000);

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)

        fun ofLabel(label: String) = values().first { it.label == label }
    }
}
