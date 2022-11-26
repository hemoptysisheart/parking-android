package com.github.hemoptysisheart.parking.core.repository

import android.util.Log
import com.github.hemoptysisheart.parking.core.room.dao.LocationDao
import com.github.hemoptysisheart.parking.core.room.entity.LocationEntity
import com.github.hemoptysisheart.parking.domain.Location

class LocationRepositoryImpl(
    private val dao: LocationDao
) : LocationRepository {
    companion object {
        private val TAG = LocationRepositoryImpl::class.simpleName
    }

    override suspend fun create(location: Location): Location {
        Log.v(TAG, "#create args : location=$location")

        location as LocationEntity

        val id = dao.insert(location)
        val inserted = dao.findById(id)!!

        Log.v(TAG, "#create return : $inserted")
        return inserted
    }
}