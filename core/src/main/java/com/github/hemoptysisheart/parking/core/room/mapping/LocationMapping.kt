package com.github.hemoptysisheart.parking.core.room.mapping

import com.github.hemoptysisheart.parking.domain.Location

/**
 * [Location]용 Jetpack Room 매핑 정보.
 */
object LocationMapping {
    const val TABLE = "location"

    /**
     * [Location.id]
     */
    const val COL_ID = "id"

    /**
     * [Location.latitude]
     */
    const val COL_LATITUDE = "latitude"

    /**
     * [Location.longitude]
     */
    const val COL_LONGITUDE = "longitude"

    /**
     * [Location.createdAt]
     */
    const val COL_CREATED_AT = "created_at"
}