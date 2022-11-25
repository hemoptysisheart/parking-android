package com.github.hemoptysisheart.parking.core.dummy.model

import com.github.hemoptysisheart.parking.core.model.MapModel
import com.google.android.gms.maps.model.LatLng
import java.time.Instant

object DummyMapModel : MapModel {
    private var center = LatLng(0.0, 0.0)

    private var zoom = MapModel.ZOOM_DEFAULT

    override suspend fun getCenter() = center

    override suspend fun setCenter(center: LatLng, timestamp: Instant) {
        this.center = center
    }

    override suspend fun getZoom() = zoom

    override suspend fun setZoom(zoom: Float, timestamp: Instant) {
        this.zoom = zoom
    }
}