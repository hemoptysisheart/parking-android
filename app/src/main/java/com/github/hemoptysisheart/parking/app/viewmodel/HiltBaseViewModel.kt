package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner

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
    return vm
}
