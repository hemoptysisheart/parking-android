package com.github.hemoptysisheart.parking.core.room.converter

import androidx.room.TypeConverter
import java.time.Instant

class InstantLongConverter {
    @TypeConverter
    fun toLong(instant: Instant?): Long? = instant?.toEpochMilli()

    @TypeConverter
    fun toInstant(value: Long?): Instant? = if (null == value) null else Instant.ofEpochMilli(value)
}