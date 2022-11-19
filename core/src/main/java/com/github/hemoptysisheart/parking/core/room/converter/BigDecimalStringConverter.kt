package com.github.hemoptysisheart.parking.core.room.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

class BigDecimalStringConverter {
    @TypeConverter
    fun toString(value: BigDecimal?) = if (null == value) null else "$value"

    @TypeConverter
    fun toBigDecimal(value: String?) = if (null == value) null else BigDecimal(value)
}