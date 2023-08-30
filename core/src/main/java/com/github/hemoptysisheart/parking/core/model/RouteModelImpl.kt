package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.repository.RouteRepository
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.route.SubRoute
import com.github.hemoptysisheart.parking.domain.route.Transportation
import com.github.hemoptysisheart.parking.domain.route.Waypoint
import javax.inject.Inject

class RouteModelImpl @Inject constructor(
        private val routeRepository: RouteRepository
) : RouteModel {
    companion object {
        private val LOGGER = AndroidLogger(RouteModelImpl::class)
    }

    override suspend fun read(id: Identifier): SubRoute? {
        LOGGER.v("#read args : id=$id")

        val route = routeRepository.read(id)

        LOGGER.v("#read return : $route")
        return route
    }

    override suspend fun search(start: Waypoint, end: Waypoint, transportation: Transportation): List<SubRoute> {
        LOGGER.v("#search args : start=$start, end=$end, transportation=$transportation")

        val routeList = routeRepository.search(start, end, transportation)

        LOGGER.v("#search return : $routeList")
        return routeList
    }
}
