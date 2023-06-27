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
    val usedCount: Int

    /**
     * 마지막 사용 시각.
     */
    val lastUsedAt: Instant
}
