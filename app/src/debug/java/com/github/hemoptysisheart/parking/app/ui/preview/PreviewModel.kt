package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.domain.GeoLocation

object PreviewModel {
    val LOCATION_MODEL = object : LocationModel {
        override val location: GeoLocation = GeoLocation(37.5638354, 126.9040477)

        override fun addCallback(key: String, callback: (GeoLocation) -> Unit) {}

        override fun removeCallback(key: String) {}
    }
}