package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

open class BaseViewModel : ViewModel(), DefaultLifecycleObserver {
    companion object {
        private val LOGGER = AndroidLogger(BaseViewModel::class)
    }

    private val progressCounter = AtomicInteger()
    private val _progress = MutableStateFlow(false)
    val progress: StateFlow<Boolean> = _progress

    fun launch(
        progress: Boolean = false,
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        LOGGER.d("#launch args : progress=$progress, context=$context, start=$start, block=$block")
        return viewModelScope.launch(context, start) {
            try {
                if (progress && 0 < progressCounter.incrementAndGet()) {
                    LOGGER.d("#launch show progress indicator")
                    _progress.emit(true)
                }
                block()
            } finally {
                if (progress && 0 >= progressCounter.decrementAndGet()) {
                    LOGGER.d("#launch hide progress indicator")
                    _progress.emit(false)
                }
            }
        }
    }
}
