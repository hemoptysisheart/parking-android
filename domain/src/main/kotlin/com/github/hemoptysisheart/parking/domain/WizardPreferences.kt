package com.github.hemoptysisheart.parking.domain

import java.time.Instant

/**
 * 앱 설정 마법사.
 */
interface WizardPreferences {
    /**
     * 앱 시작할 때 보일지 여부.
     */
    var bootUpShow: Boolean

    /**
     * 사용자가 본 횟수.
     */
    val showCount: Int

    /**
     * 마지막 사용 시각.
     */
    val lastShownAt: Instant

    /**
     * [WizardPreferences.showCount]를 1 증가시키고 [WizardPreferences.lastShownAt]를 현재 시각으로 갱신한다.
     */
    fun increaseShowCount()
}
