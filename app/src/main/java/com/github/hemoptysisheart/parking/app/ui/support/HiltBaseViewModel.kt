package com.github.hemoptysisheart.parking.app.ui.support

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel

@Composable
inline fun <reified VM : BaseViewModel> hiltBaseViewModel(
    viewModelStoreOwner: ViewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    }
): VM {
    val vm: VM = hiltViewModel(viewModelStoreOwner)

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(vm) {
        lifecycle.addObserver(vm)

        onDispose {
            lifecycle.removeObserver(vm)
        }
    }

    val progress by vm.progress.collectAsStateWithLifecycle()
    var p by remember("progress") {
        mutableStateOf(progress)
    }
    p = progress

    return vm
}
