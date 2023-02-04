package com.github.hemoptysisheart.parking.app.ui.state

import android.util.Log
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE

data class MainScreenState(
    /**
     * 추천 항목을 포함하는 오버레이를 열어서 보일지 여부.
     */
    var overlayState: OverlayState = OverlayState.COLLAPSE
) {
    fun shiftHideCollapse() {
        Log.v(TAG_COMPOSE, "#shiftHideCollapse called : overlayState=$overlayState")
        when (overlayState) {
            OverlayState.HIDE ->
                overlayState = OverlayState.COLLAPSE
            OverlayState.COLLAPSE ->
                overlayState = OverlayState.HIDE
            else ->
                Log.e(TAG_COMPOSE, "#shiftHideCollapse illegal state : overlayState=$overlayState")
        }
    }
}
