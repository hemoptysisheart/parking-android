package com.github.hemoptysisheart.parking.core.client.google.data

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class PlaceSpecialDay(
    val date: LocalDate? = null,
    val exceptionalHours: Boolean = false
) {
    companion object {
        const val DATE_PATTERN = "yyyy-MM-dd"

        val DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN)
    }
}
