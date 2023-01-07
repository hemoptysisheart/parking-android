package com.github.hemoptysisheart.parking.core.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.hemoptysisheart.parking.core.room.entity.MapStateEntity
import com.github.hemoptysisheart.parking.core.room.mapping.MapStateMapping.COL_ID
import com.github.hemoptysisheart.parking.core.room.mapping.MapStateMapping.TABLE

@Dao
interface MapStateDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(entity: MapStateEntity): Long

    @Query("SELECT * FROM $TABLE WHERE $COL_ID = :id")
    suspend fun findById(id: Long): MapStateEntity?
}