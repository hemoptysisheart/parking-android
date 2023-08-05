package com.github.hemoptysisheart.parking.app.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.github.hemoptysisheart.parking.core.model.GlobalChannel
import com.github.hemoptysisheart.parking.core.model.GlobalChannelConsumer
import com.github.hemoptysisheart.parking.core.model.GlobalChannelImpl

@Composable
private fun previewGlobalChannelImpl() = remember {
    GlobalChannelImpl()
}

@Composable
fun previewGlobalChannelConsumer(): GlobalChannelConsumer = previewGlobalChannelImpl()

@Composable
fun previewGlobalChannel(): GlobalChannel = previewGlobalChannelImpl()