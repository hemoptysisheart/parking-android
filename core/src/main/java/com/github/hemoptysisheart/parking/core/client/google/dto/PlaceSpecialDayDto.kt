package com.github.hemoptysisheart.parking.core.client.google.dto

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class PlaceSpecialDayDto(
    val date: LocalDate?,
    val exceptionalHours: Boolean = false
) {
    companion object {
        const val DATE_PATTERN = "yyyy-MM-dd"

        val DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN)
    }
}
