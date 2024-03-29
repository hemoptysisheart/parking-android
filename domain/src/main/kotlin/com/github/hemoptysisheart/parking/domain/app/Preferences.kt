package com.github.hemoptysisheart.parking.domain.app

/**
 * 앱 설정 정보.
 */
interface Preferences {
    /**
     * 앱 설치에 관한 정보.
     */
    val install: InstallPreferences

    /**
     * 실행 설정.
     */
    val execution: ExecutionPreferences

    /**
     * 앱 가이드 설정.
     */
    val wizard: WizardPreferences

    /**
     * 검색 설정
     */
    val search: SearchPreferences
}
