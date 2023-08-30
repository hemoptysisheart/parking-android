package com.github.hemoptysisheart.parking.core.repository

import com.github.hemoptysisheart.parking.client.google.MapsClient
import com.github.hemoptysisheart.parking.client.google.data.DirectionsParams
import com.github.hemoptysisheart.parking.core.domain.route.mode
import com.github.hemoptysisheart.parking.core.domain.route.toPlaceDescriptor
import com.github.hemoptysisheart.parking.core.domain.route.toSubRoute
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.route.SubRoute
import com.github.hemoptysisheart.parking.domain.route.Transportation
import com.github.hemoptysisheart.parking.domain.route.Waypoint
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

class RouteRepositoryImpl @Inject constructor(
        private val mapsClient: MapsClient
) : RouteRepository {
    companion object {
        private val LOGGER = AndroidLogger(RouteRepositoryImpl::class)
    }

    private val routeCacheLock = Mutex()
    private val routeCache = mutableMapOf<Identifier, SubRoute>()

    override suspend fun search(start: Waypoint, end: Waypoint, transportation: Transportation): List<SubRoute> {
        LOGGER.v("#search args : start=$start, end=$end")

        val params = DirectionsParams(
                origin = start.toPlaceDescriptor(),
                destination = end.toPlaceDescriptor(),
                transportationMode = transportation.mode
        )
        val directions = mapsClient.directions(params)
        val routeList = directions.map { it.toSubRoute(start, end, transportation) }
        routeCacheLock.withLock {
            for (subRoute in routeList) {
                routeCache[subRoute.id] = subRoute
            }
        }

        LOGGER.v("#search return: $routeList")
        return routeList
    }
}
