package com.github.hemoptysisheart.parking.app.ui.state

data class MainScreenState(
    /**
     * 추천 항목을 포함하는 오버레이를 열어서 보일지 여부.
     */
    var overlayState: OverlayState = OverlayState.COLLAPSE
)