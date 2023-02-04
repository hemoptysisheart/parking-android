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
    fun shiftHideCollapse() {
        Log.v(TAG_COMPOSE, "#shiftHideCollapse called : overlayState=$overlayState")
        when (overlayState) {
            HIDE ->
                overlayState = COLLAPSE
            COLLAPSE ->
                overlayState = HIDE
            else ->
                Log.e(TAG_COMPOSE, "#shiftHideCollapse illegal state : overlayState=$overlayState")
        }
    }

    fun shiftCollapseExpand() {
        Log.v(TAG_COMPOSE, "#shiftCollapseExpand called : overlayState=$overlayState")

        when (overlayState) {
            HIDE ->
                Log.e(TAG_COMPOSE, "#shiftCollapseExpand illegal state : overlayState=$overlayState")
            COLLAPSE ->
                overlayState = EXTEND
            EXTEND ->
                overlayState = COLLAPSE
        }
    }
}
