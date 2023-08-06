package com.github.hemoptysisheart.parking.app.ui.resource

import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import java.text.NumberFormat

@Suppress("MemberVisibilityCanBePrivate")
enum class DistanceUnitRes(
        val unit: DistanceUnit,
        val numberFormat: NumberFormat
) {
    METER(DistanceUnit.METER, NumberFormat.getIntegerInstance()),
    KILOMETER(DistanceUnit.KILOMETER, NumberFormat.getNumberInstance());

    fun format(meter: Number): String = numberFormat.format(meter.toDouble() / unit.mpu)

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)

        operator fun get(unit: DistanceUnit) = values().first { unit == it.unit }
    }
}
