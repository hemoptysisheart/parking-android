package com.github.hemoptysisheart.parking.core.client.google.dto

import java.time.LocalDate

data class PlaceSpecialDayDto(
    val date: LocalDate?,
    val exceptionalHours: Boolean = false
)
