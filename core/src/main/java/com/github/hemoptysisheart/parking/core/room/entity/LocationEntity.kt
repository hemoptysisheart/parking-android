package com.github.hemoptysisheart.parking.core.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.hemoptysisheart.parking.core.room.mapping.LocationMapping
import com.github.hemoptysisheart.parking.core.room.mapping.LocationMapping.COL_LATITUDE
import com.github.hemoptysisheart.parking.core.room.mapping.LocationMapping.COL_LONGITUDE
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.Location.Companion.ID_VALIDATOR
import com.github.hemoptysisheart.parking.domain.Location.Companion.LATITUDE_VALIDATOR
import com.github.hemoptysisheart.parking.domain.Location.Companion.LONGITUDE_VALIDATOR
import com.github.hemoptysisheart.util.ToSimpleString
import java.math.BigDecimal

@Entity(tableName = LocationMapping.TABLE)
class LocationEntity(
    /**
     * 위도
     */
    @ColumnInfo(name = COL_LATITUDE)
    override val latitude: BigDecimal,
    /**
     * 경도
     */
    @ColumnInfo(name = COL_LONGITUDE)
    override val longitude: BigDecimal
) : Location, ToSimpleString {
    companion object {
        val TAG = LocationEntity::class.simpleName
    }

    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0L

    init {
        ID_VALIDATOR(id)
        LATITUDE_VALIDATOR(latitude)
        LONGITUDE_VALIDATOR(longitude)
    }

    override fun toSimpleString() = "$latitude,$longitude"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LocationEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode() = id.hashCode()

    override fun toString() = "$TAG(id=$id, latitude=$latitude, longitude=$longitude)"
}