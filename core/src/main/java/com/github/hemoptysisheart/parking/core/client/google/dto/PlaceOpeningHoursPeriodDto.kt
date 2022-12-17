package com.github.hemoptysisheart.parking.core.client.google.dto

data class PlaceOpeningHoursPeriodDto(
    val open: PlaceOpeningHoursPeriodDetailDto,
    val close: PlaceOpeningHoursPeriodDetailDto?
)
