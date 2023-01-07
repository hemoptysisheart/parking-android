package com.github.hemoptysisheart.parking.core.repository

import android.util.Log
import com.github.hemoptysisheart.parking.core.room.dao.MapStateDao
import com.github.hemoptysisheart.parking.core.room.entity.MapStateEntity
import com.github.hemoptysisheart.parking.domain.MapState

class MapStateRepositoryImpl(
    private val dao: MapStateDao
) : MapStateRepository {
    companion object {
        private val TAG = MapStateRepositoryImpl::class.simpleName
    }

    override suspend fun create(state: MapState): MapState {
        Log.v(TAG, "#create args : state=$state")

        state as MapStateEntity

        val id = dao.insert(state)
        val entity = dao.findById(id)!!

        Log.v(TAG, "#create return : $entity")
        return entity
    }
}