package com.github.hemoptysisheart.parking.core.model

import android.util.Log
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
        // TODO 저장.
        delay(1L)
    }

    override suspend fun setCenter(center: LatLng, timestamp: Instant) {
        val dirty = center != this.center
        this.center = center

        if (dirty) {
            saveState(timestamp)
        }
    }

    override suspend fun setZoom(zoom: Float, timestamp: Instant) {
        val dirty = zoom != this.zoom
        this.zoom = zoom

        if (dirty) {
            saveState(timestamp)
        }
    }

    override fun toString() = "$TAG(center=$center, zoom=$zoom)"
}