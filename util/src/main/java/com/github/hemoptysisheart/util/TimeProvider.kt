package com.github.hemoptysisheart.util

import java.time.*

/**
 * 시각 정보를 제공하는 공통 도구.
 *
 * 특히 [Clock] 사용을 숨길 때 사용.
 */
interface TimeProvider {
    val zoneId: ZoneId

    fun instant(): Instant

    fun zonedDateTime() = ZonedDateTime.ofInstant(instant(), zoneId)

    fun offsetTime() = OffsetTime.ofInstant(instant(), zoneId)

    fun offsetDateTime() = OffsetDateTime.ofInstant(instant(), zoneId)

    fun localDate() = LocalDate.ofInstant(instant(), zoneId)

    fun localTime() = LocalTime.ofInstant(instant(), zoneId)

    fun localDateTime() = LocalDateTime.ofInstant(instant(), zoneId)

    fun year() = Year.from(instant())

    fun yearMonth() = YearMonth.from(instant())
}