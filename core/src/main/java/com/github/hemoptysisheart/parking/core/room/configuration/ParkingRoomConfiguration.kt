package com.github.hemoptysisheart.parking.core.room.configuration

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.hemoptysisheart.parking.core.room.converter.BigDecimalConverter
import com.github.hemoptysisheart.parking.core.room.dao.LocationDao
import com.github.hemoptysisheart.parking.core.room.entity.LocationEntity

@Database(entities = [LocationEntity::class], version = 1)
@TypeConverters(BigDecimalConverter::class)
abstract class ParkingRoomConfiguration : RoomDatabase() {
    abstract fun locationDao(): LocationDao
}