package com.github.hemoptysisheart.parking.client.google.data

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class PlaceOpeningHoursPeriodDetail(
        val day: DayOfWeek,
        val time: LocalTime,
        val date: LocalDate? = null,
        val truncated: Boolean = false
) {
    @Suppress("MemberVisibilityCanBePrivate")
    companion object {
        const val TIME_PATTERN = "HHmm"

        val TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN)!!

        const val DATE_PATTERN = "yyyy-MM-dd"

        val DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN)!!

        fun codeToDayOfWeek(code: Int): DayOfWeek = when (code) {
            0 -> DayOfWeek.SUNDAY
            1 -> DayOfWeek.MONDAY
            2 -> DayOfWeek.TUESDAY
            3 -> DayOfWeek.WEDNESDAY
            4 -> DayOfWeek.THURSDAY
            5 -> DayOfWeek.FRIDAY
            6 -> DayOfWeek.SATURDAY
            else -> throw IllegalArgumentException("illegal code : code=$code")
        }
    }

    constructor(day: Int, time: LocalTime, date: LocalDate?, truncated: Boolean) : this(
            codeToDayOfWeek(day),
            time,
            date,
            truncated
    )
}
