package com.github.hemoptysisheart.parking.core.client.google.dto

data class PlaceOpeningHours(
    val open: Boolean? = null,
    val periods: List<PlaceOpeningHoursPeriod>? = null,
    val specialDays: List<PlaceSpecialDay>? = null,
    val type: PlaceOpeningHoursType? = null,
    val weekdays: List<String>? = null
)
