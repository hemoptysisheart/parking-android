package com.github.hemoptysisheart.parking.app.ui.support

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.StateFlow

/**
 * [hiltViewModel]을 확장에 기본적인 추가 기능을 실행한다.
 */
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

/**
 * vm의 플로우 값을 Compose로 가져오기 쉽게 만드는 유틸리티 메서드.
 *
 * @see StateFlow.collectAsStateWithLifecycle
 */
@Composable
inline fun <reified T> StateFlow<T>.collect(): T {
    val value by this.collectAsStateWithLifecycle()
    return value
}

/**
 * vm의 플로우 값을 Compose로 가져오기 쉽게 만드는 유틸리티 메서드.
 *
 * @see StateFlow.collectAsStateWithLifecycle
 */
@Composable
inline fun <reified T> BaseViewModel.VmProperty<T>.collect(): T {
    val value by this.value.collectAsStateWithLifecycle()
    return value
}
