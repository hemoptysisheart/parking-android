package com.github.hemoptysisheart.parking.core.dummy.model

import com.github.hemoptysisheart.parking.core.model.MapModel
import com.google.android.gms.maps.model.LatLng
import java.time.Instant

object DummyMapModel : MapModel {
    override var center = LatLng(0.0, 0.0)

    override var zoom = MapModel.ZOOM_DEFAULT

    override suspend fun setCenter(center: LatLng, timestamp: Instant) {
        this.center = center
    }

    override suspend fun setZoom(zoom: Float, timestamp: Instant) {
        this.zoom = zoom
    }
}