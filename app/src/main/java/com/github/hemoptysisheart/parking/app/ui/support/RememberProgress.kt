package com.github.hemoptysisheart.parking.app.ui.support

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun rememberProgress(): Boolean {
    val progress by remember("progress") {
        mutableStateOf(false)
    }

    return progress
}