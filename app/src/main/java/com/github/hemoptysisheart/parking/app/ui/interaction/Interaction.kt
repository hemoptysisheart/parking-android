package com.github.hemoptysisheart.parking.app.ui.interaction

import android.content.Context
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavHostController

/**
 * 사용자가 애플리케이션을 조작할 때 필요한 기본 상호작용을 제공한다.
 *
 * - Compose Navigation을 사용한 탐색.
 * - 소프트웨어 키보드 보이기/숨기기.
 */
interface Interaction {
    val context: Context

    val navController: NavHostController

    @OptIn(ExperimentalComposeUiApi::class)
    val softwareKeyboardController: SoftwareKeyboardController?

    fun onBack()

    /**
     * 가상 키보드 숨기기.
     */
    fun showSoftwareKeyboard()

    /**
     * 가상 키보드 보이기.
     */
    fun hideSoftwareKeyboard()
}