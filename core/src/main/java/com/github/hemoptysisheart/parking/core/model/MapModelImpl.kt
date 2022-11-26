package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.model.param.MapStateParams
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.delay
import java.time.Instant

class MapModelImpl : MapModel {
    companion object {
        private val TAG = MapModelImpl::class.simpleName
    }

    override var center = LatLng(0.0, 0.0)
        private set

    override var zoom: Float = MapModel.ZOOM_DEFAULT
        private set

    /**
     * 모델 상태가 갱신됐다고 보고 저장한다.
     */
    private suspend fun saveState(timestamp: Instant) {
        Log.v(TAG, "#saveState : center=$center, zoom=$zoom, timestamp=$timestamp")

        delay(1L) // TODO 저장 로직으로 교체.
    }

    override suspend fun update(params: MapStateParams) {
        val dirty = center != params.center ||
                zoom != params.zoom

        center = params.center
        zoom = params.zoom

        if (dirty) {
            saveState(params.timestamp)
        }
    }

    override fun toString() = "$TAG(center=$center, zoom=$zoom)"
}