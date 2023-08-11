package com.github.hemoptysisheart.parking.app.ui.support

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable

/**
 *
 */
@Composable
fun requestPermission(
        permission: String,
        onGranted: () -> Unit = { },
        onDenied: () -> Unit = { }
): () -> Unit {
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {
        if (it) {
            onGranted()
        } else {
            onDenied()
        }
    }
    return { launcher.launch(permission) }
}
