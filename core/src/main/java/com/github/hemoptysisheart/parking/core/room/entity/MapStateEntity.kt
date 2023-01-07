package com.github.hemoptysisheart.parking.core.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.hemoptysisheart.parking.core.room.mapping.MapStateMapping.COL_CREATED_AT
import com.github.hemoptysisheart.parking.core.room.mapping.MapStateMapping.COL_ID
import com.github.hemoptysisheart.parking.core.room.mapping.MapStateMapping.COL_LATITUDE
import com.github.hemoptysisheart.parking.core.room.mapping.MapStateMapping.COL_LONGITUDE
import com.github.hemoptysisheart.parking.core.room.mapping.MapStateMapping.COL_ZOOM
import com.github.hemoptysisheart.parking.core.room.mapping.MapStateMapping.TABLE
import com.github.hemoptysisheart.parking.domain.MapState
import com.github.hemoptysisheart.parking.domain.MapState.Companion.ZOOM_VALIDATOR
import com.github.hemoptysisheart.util.NumberValidators.LATITUDE_VALIDATOR
import com.github.hemoptysisheart.util.NumberValidators.LONGITUDE_VALIDATOR
import com.github.hemoptysisheart.util.ToSimpleString
import java.time.Instant

@Entity(tableName = TABLE)
class MapStateEntity(
    @ColumnInfo(name = COL_LATITUDE)
    override val latitude: Double,
    @ColumnInfo(name = COL_LONGITUDE)
    override val longitude: Double,
    @ColumnInfo(name = COL_ZOOM)
    override val zoom: Float,
    @ColumnInfo(name = COL_CREATED_AT)
    override val createdAt: Instant
) : MapState, ToSimpleString {
    companion object {
        private val TAG = MapStateEntity::class.simpleName
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_ID)
    override var id = 0L

    init {
        LATITUDE_VALIDATOR.validate(latitude)
        LONGITUDE_VALIDATOR.validate(longitude)
        ZOOM_VALIDATOR.validate(zoom)
    }

    override fun toSimpleString() = "%.6f,%.6f zoom=%.2f".format(latitude, longitude, zoom)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return other is MapStateEntity &&
                id == other.id
    }

    override fun hashCode() = id.hashCode()

    override fun toString() = "$TAG(id=$id, latitude=$latitude, longitude=$longitude, zoom=$zoom, createdAt=$createdAt)"
}
