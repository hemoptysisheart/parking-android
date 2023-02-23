package com.github.hemoptysisheart.parking.core.client.google.dto

data class PlaceOpeningHoursPeriod(
    val open: PlaceOpeningHoursPeriodDetail,
    val close: PlaceOpeningHoursPeriodDetail? = null
)
