package com.github.hemoptysisheart.util

import java.time.Instant
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit

class TruncatedTimeProvider(
    val unit: TemporalUnit = ChronoUnit.MILLIS,
    override val zoneId: ZoneId = ZoneId.systemDefault()
) : TimeProvider {
    override fun instant(): Instant = Instant.now().truncatedTo(unit)

    override fun toString() = "TruncatedTimeProvider(unit=$unit, zoneId=$zoneId)"
}