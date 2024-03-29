package com.github.hemoptysisheart.parking.app.interaction

import android.net.Uri

/**
 * 사용자가 애플리케이션을 조작할 때 필요한 기본 상호작용을 제공한다.
 *
 * - Compose Navigation을 사용한 탐색.
 * - 소프트웨어 키보드 보이기/숨기기.
 */
interface Interaction {
    /**
     * 돌아가기.
     */
    fun goBack()

    /**
     * 외부 브라우저 열기.
     */
    fun openWeb(uri: String) = openWebPage(Uri.parse(uri))

    /**
     * 외부 브라우저 열기.
     */
    fun openWebPage(uri: Uri)

    /**
     * 가상 키보드 숨기기.
     */
    fun showSoftwareKeyboard()

    /**
     * 가상 키보드 보이기.
     */
    fun hideSoftwareKeyboard()
}
