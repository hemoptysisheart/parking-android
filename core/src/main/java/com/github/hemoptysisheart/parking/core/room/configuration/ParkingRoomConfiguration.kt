package com.github.hemoptysisheart.parking.core.room.configuration

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.hemoptysisheart.parking.core.room.converter.BigDecimalStringConverter
import com.github.hemoptysisheart.parking.core.room.converter.InstantLongConverter
import com.github.hemoptysisheart.parking.core.room.dao.LocationDao
import com.github.hemoptysisheart.parking.core.room.dao.MapStateDao
import com.github.hemoptysisheart.parking.core.room.entity.LocationEntity
import com.github.hemoptysisheart.parking.core.room.entity.MapStateEntity

@Database(entities = [LocationEntity::class, MapStateEntity::class], version = 1)
@TypeConverters(BigDecimalStringConverter::class, InstantLongConverter::class)
abstract class ParkingRoomConfiguration : RoomDatabase() {
    abstract fun locationDao(): LocationDao

    abstract fun mapStateDao(): MapStateDao
}