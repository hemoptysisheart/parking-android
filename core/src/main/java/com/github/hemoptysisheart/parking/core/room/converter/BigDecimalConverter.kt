package com.github.hemoptysisheart.parking.core.room.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

class BigDecimalConverter {
    @TypeConverter
    fun toBigDecimal(value: String?) = if (null == value) null else BigDecimal(value)

    @TypeConverter
    fun fromBigDecimal(value: BigDecimal?) = if (null == value) null else "$value"
}