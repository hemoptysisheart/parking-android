package com.github.hemoptysisheart.parking.core.client.google.dto

data class PlaceOpeningHoursDto(
    val open: Boolean?,
    val periods: List<PlaceOpeningHoursPeriodDto>?,
    val specialDays: List<PlaceSpecialDayDto>?,
    val type: PlaceOpeningHoursType?,
    val weekdays: List<String>?
)
