package com.github.hemoptysisheart.parking.core.room.dao

import androidx.room.*
import com.github.hemoptysisheart.parking.core.room.entity.LocationEntity
import com.github.hemoptysisheart.parking.core.room.mapping.LocationMapping.COL_ID
import com.github.hemoptysisheart.parking.core.room.mapping.LocationMapping.TABLE

@Dao
interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(location: LocationEntity): Long

    @Query("SELECT * FROM $TABLE")
    fun list(): List<LocationEntity>

    @Query("SELECT * FROM $TABLE WHERE $COL_ID = :id")
    fun findById(id: Long): LocationEntity?

    @Delete
    suspend fun delete(location: LocationEntity)

    @Query("DELETE FROM $TABLE")
    suspend fun clear()
}