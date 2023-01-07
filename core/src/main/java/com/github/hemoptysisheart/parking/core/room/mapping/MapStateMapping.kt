package com.github.hemoptysisheart.parking.core.room.mapping

import com.github.hemoptysisheart.parking.domain.MapState

/**
 * [MapState]
 */
object MapStateMapping {
    const val TABLE = "map_state"

    /**
     * [MapState.id]
     */
    const val COL_ID = "id"

    /**
     * [MapState.latitude]
     */
    const val COL_LATITUDE = "latitude"

    /**
     * [MapState.longitude]
     */
    const val COL_LONGITUDE = "longitude"

    /**
     * [MapState.zoom]
     */
    const val COL_ZOOM = "zoom"

    /**
     * [MapState.createdAt]
     */
    const val COL_CREATED_AT = "created_at"
}