package com.github.hemoptysisheart.util

import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.OffsetTime
import java.time.Year
import java.time.YearMonth
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * 시각 정보를 제공하는 공통 도구.
 *
 * 특히 [Clock] 사용을 숨길 때 사용.
 */
interface TimeProvider {
    val zoneId: ZoneId

    /**
     * @see Instant.now
     */
    fun instant(): Instant

    /**
     * @see ZonedDateTime.now
     */
    fun zonedDateTime() = ZonedDateTime.ofInstant(instant(), zoneId)

    /**
     * @see OffsetTime.now
     */
    fun offsetTime() = OffsetTime.ofInstant(instant(), zoneId)

    /**
     * @see OffsetDateTime.now
     */
    fun offsetDateTime() = OffsetDateTime.ofInstant(instant(), zoneId)

    /**
     * @see LocalDate.now
     */
    fun localDate() = LocalDate.ofInstant(instant(), zoneId)

    /**
     * @see LocalTime.now
     */
    fun localTime() = LocalTime.ofInstant(instant(), zoneId)

    /**
     * @see LocalDateTime.now
     */
    fun localDateTime() = LocalDateTime.ofInstant(instant(), zoneId)

    /**
     * @see Year.now
     */
    fun year() = Year.from(localDate())

    /**
     * @see YearMonth.now
     */
    fun yearMonth() = YearMonth.from(localDate())
}