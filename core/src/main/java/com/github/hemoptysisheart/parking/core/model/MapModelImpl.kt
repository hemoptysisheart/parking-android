package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.model.param.MapStateParams
import com.github.hemoptysisheart.parking.core.repository.MapStateRepository
import com.github.hemoptysisheart.parking.core.room.entity.MapStateEntity

class MapModelImpl(
    private val repository: MapStateRepository
) : MapModel {
    companion object {
        private val TAG = MapModelImpl::class.simpleName
    }

    override var center = MapModel.LAT_LNG_DEFAULT
        private set

    override var zoom: Float = MapModel.ZOOM_DEFAULT
        private set

    /**
     * 모델 상태가 갱신됐다다면 저장한다.
     *
     * TODO 마지막 정보와 차이가 작을 경우엔 저장 생략하기.
     */
    private suspend fun saveState(params: MapStateParams) {
        val entity = repository.create(
            MapStateEntity(
                params.center.latitude,
                params.center.longitude,
                params.zoom,
                params.timestamp
            )
        )
        Log.v(TAG, "#saveState : params=$params, entity=$entity")
    }

    override suspend fun update(params: MapStateParams) {
        center = params.center
        zoom = params.zoom

        saveState(params)
    }

    override fun toString() = "$TAG(center=$center, zoom=$zoom)"
}