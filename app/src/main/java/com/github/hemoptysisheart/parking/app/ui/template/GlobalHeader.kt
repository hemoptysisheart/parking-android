package com.github.hemoptysisheart.parking.app.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.hemoptysisheart.parking.app.interaction.main.GlobalHeaderInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.viewmodel.GlobalHeaderViewModel
import com.github.hemoptysisheart.parking.core.util.AndroidMessageException

@Composable
fun GlobalHeader(
        interaction: GlobalHeaderInteraction,
        viewModel: GlobalHeaderViewModel = hiltViewModel()
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(GlobalHeaderViewModel::class) {
        lifecycle.addObserver(viewModel)
        onDispose {
            lifecycle.removeObserver(viewModel)
        }
    }

    val progress by viewModel.progress.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()

    GlobalHeaderContent(progress, error, viewModel::onClearError)
}

@Composable
private fun GlobalHeaderContent(
        progress: Boolean,
        error: AndroidMessageException? = null,
        onClearError: () -> Unit = {}
) {
    if (null != error) {
        GlobalAlertDialog(error, onClearError)
    }

    if (progress) {
        LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                trackColor = Color.Transparent
        )
    } else {
        Box(
                modifier = Modifier
                        .background(Color.Transparent)
                        .fillMaxWidth()
                        .height(4.dp)
        )
    }
}

@Composable
@PagePreview
fun Preview_GlobalHeader_Progress() {
    ComponentPreviewContainer {
        GlobalHeaderContent(progress = true)
    }
}


@Composable
@PagePreview
fun Preview_GlobalHeader_NotProgress() {
    ComponentPreviewContainer {
        GlobalHeaderContent(progress = false)
    }
}
