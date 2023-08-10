package com.github.hemoptysisheart.parking.client.google.data

data class PlaceOpeningHoursPeriod(
        val open: PlaceOpeningHoursPeriodDetail,
        val close: PlaceOpeningHoursPeriodDetail? = null
)
