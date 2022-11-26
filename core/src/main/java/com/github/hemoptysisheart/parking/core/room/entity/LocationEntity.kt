package com.github.hemoptysisheart.parking.core.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.hemoptysisheart.parking.core.room.mapping.LocationMapping
import com.github.hemoptysisheart.parking.core.room.mapping.LocationMapping.COL_CREATED_AT
import com.github.hemoptysisheart.parking.core.room.mapping.LocationMapping.COL_LATITUDE
import com.github.hemoptysisheart.parking.core.room.mapping.LocationMapping.COL_LONGITUDE
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.util.NumberValidators.LATITUDE_VALIDATOR
import com.github.hemoptysisheart.util.NumberValidators.LONGITUDE_VALIDATOR
import com.github.hemoptysisheart.util.ToSimpleString
import java.time.Instant

@Entity(tableName = LocationMapping.TABLE)
class LocationEntity(
    /**
     * 위도
     */
    @ColumnInfo(name = COL_LATITUDE)
    override val latitude: Double,
    /**
     * 경도
     */
    @ColumnInfo(name = COL_LONGITUDE)
    override val longitude: Double,
    @ColumnInfo(name = COL_CREATED_AT)
    override val createdAt: Instant
) : Location, ToSimpleString {
    companion object {
        val TAG = LocationEntity::class.simpleName
    }

    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0L

    init {
        LATITUDE_VALIDATOR.validate(latitude)
        LONGITUDE_VALIDATOR.validate(longitude)
    }

    override fun toSimpleString() = "%.6f,%.6f".format(latitude, longitude)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LocationEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode() = id.hashCode()

    override fun toString() = "$TAG(id=$id, latitude=$latitude, longitude=$longitude, createdAt=$createdAt)"
}