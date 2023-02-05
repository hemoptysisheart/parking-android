package com.github.hemoptysisheart.parking.app.ui.state

import android.util.Log
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.state.OverlayState.*

data class MainScreenState(
    /**
     * 추천 항목을 포함하는 오버레이를 열어서 보일지 여부.
     */
    var overlayState: OverlayState = COLLAPSE
) {
    fun onHide() {
        if (COLLAPSE == overlayState) {
            overlayState = HIDE
        } else {
            Log.w(TAG_COMPOSE, "#onHide illegal state : overlayState=$overlayState")
        }
    }

    fun onShow() {
        if (HIDE == overlayState) {
            overlayState = COLLAPSE
        } else {
            Log.w(TAG_COMPOSE, "#onShow illegal state : overlayState=$overlayState")
        }
    }

    fun onExtend() {
        if (COLLAPSE == overlayState) {
            overlayState = EXTEND
        } else {
            Log.w(TAG_COMPOSE, "#onExtend illegal state : overlayState=$overlayState")
        }
    }

    fun onCollapse() {
        if (EXTEND == overlayState) {
            overlayState = COLLAPSE
        } else {
            Log.w(TAG_COMPOSE, "#onCollapse illegal state : overlayState=$overlayState")
        }
    }
}
