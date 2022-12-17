package com.github.hemoptysisheart.parking.core.client.google.dto

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

data class PlaceOpeningHoursPeriodDetailDto(
    val day: DayOfWeek,
    val time: LocalTime,
    val date: LocalDate?,
    val truncated: Boolean
) {
    companion object {
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
