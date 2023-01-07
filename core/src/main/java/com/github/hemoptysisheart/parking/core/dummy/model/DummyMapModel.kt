package com.github.hemoptysisheart.parking.core.dummy.model

import com.github.hemoptysisheart.parking.core.model.MapModel
import com.github.hemoptysisheart.parking.core.model.param.MapStateParams
import com.google.android.gms.maps.model.LatLng

object DummyMapModel : MapModel {
    override var center = LatLng(0.0, 0.0)

    override var zoom = MapModel.ZOOM_DEFAULT

    override suspend fun update(state: MapStateParams) {
        center = state.center
        zoom = state.zoom
    }
}