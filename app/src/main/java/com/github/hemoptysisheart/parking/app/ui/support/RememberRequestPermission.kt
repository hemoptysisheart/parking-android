package com.github.hemoptysisheart.parking.app.ui.support

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_SUPPORT as LOGGER

/**
 * 권한을 요청할 수 있는 다이얼로그 런처를 반환한다.
 *
 * 요청하는 권한과 결과 핸들러를 기준으로 기억([remember])한다.
 */
@Composable
fun rememberRequestPermission(
    permission: String,
    onGranted: () -> Unit,
    onDenied: () -> Unit = {}
): RequestPermission {
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {
        LOGGER.i("#RequestPermission.onResult : $permission => $it")
        if (it) {
            onGranted()
        } else {
            onDenied()
        }
    }

    return remember(permission, onGranted, onDenied) { RequestPermission(launcher, permission) }
}
