package com.github.hemoptysisheart.parking.app.ui.support

import androidx.activity.compose.ManagedActivityResultLauncher
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_SUPPORT as LOGGER

/**
 * 권한 요청 다이얼로그 런처.
 */
class RequestPermission(
    private val launcher: ManagedActivityResultLauncher<String, Boolean>,
    private val permission: String
) {
    operator fun invoke() {
        LOGGER.i("#invoke called.")
        launcher.launch(permission)
    }
}
