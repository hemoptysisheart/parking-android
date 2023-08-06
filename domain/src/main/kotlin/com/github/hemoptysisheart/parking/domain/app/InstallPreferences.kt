package com.github.hemoptysisheart.parking.domain.app

import java.util.UUID

/**
 * 앱 설치에 관한 정보.
 */
interface InstallPreferences {
    /**
     * 앱 설치 ID. 앱을 재설치 하거나 스토리지를 삭제하면 초기화된다.
     */
    val installId: UUID
}