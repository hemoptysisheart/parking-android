package com.github.hemoptysisheart.parking.core.client.google.dto

data class PlaceOpeningHoursDto(
    val open: Boolean? = null,
    val periods: List<PlaceOpeningHoursPeriodDto>? = null,
    val specialDays: List<PlaceSpecialDayDto>? = null,
    val type: PlaceOpeningHoursType? = null,
    val weekdays: List<String>? = null
)
