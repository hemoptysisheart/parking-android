package com.github.hemoptysisheart.parking.core.dummy.model

import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.domain.Coordinate

object DummyLocationModel : LocationModel {
    override var location = Coordinate(0.0, 0.0)

    override suspend fun update(src: android.location.Location) = Coordinate(src.latitude, src.longitude)
}