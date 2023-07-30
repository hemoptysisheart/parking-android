package com.github.hemoptysisheart.parking.domain.app

import java.time.Instant

/**
 * 실행 정보.
 */
interface ExecutionPreferences {
    /**
     * 최초 실행 시각.
     */
    val initStartAt: Instant

    /**
     * 프로세스 시작 횟수.
     */
    val coldStartCount: Long

    /**
     * 마지막 프로세스 시작 시각.
     */
    val lastColdStartAt: Instant

    /**
     * 앱이 전면에 나온 횟수.
     */
    val foregroundCount: Long

    /**
     * 마지막으로 앱이 전면에 나온 시각.
     */
    val lastForegroundAt: Instant
}
