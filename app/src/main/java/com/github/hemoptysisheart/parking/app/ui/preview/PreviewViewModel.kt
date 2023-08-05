package com.github.hemoptysisheart.parking.app.ui.preview

import androidx.compose.runtime.Composable
import com.github.hemoptysisheart.parking.app.viewmodel.GlobalHeaderViewModel
import com.github.hemoptysisheart.parking.core.model.GlobalChannelConsumer

@Composable
fun previewGlobalHeaderViewModel(
    globalChannelConsumer: GlobalChannelConsumer = previewGlobalChannelConsumer()
) = GlobalHeaderViewModel(globalChannelConsumer)
