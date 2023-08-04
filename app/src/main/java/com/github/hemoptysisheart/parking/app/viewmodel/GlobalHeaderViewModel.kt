package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.GlobalChannelConsumer
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.core.util.AndroidMessageException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

@HiltViewModel
class GlobalHeaderViewModel @Inject constructor(
    private val globalChannelConsumer: GlobalChannelConsumer,
) : ViewModel(), DefaultLifecycleObserver {
    companion object {
        private val LOGGER = AndroidLogger(GlobalHeaderViewModel::class)
    }

    private val progressMutex = Mutex()
    private var _progress = 0
    val progress = MutableStateFlow(false)

    private val errorMutex = Mutex()
    private val errorQueue = mutableListOf<AndroidMessageException>()
    val error = MutableStateFlow<AndroidMessageException?>(null)

    init {
        globalChannelConsumer.progressConsumer = GlobalChannelConsumer.Consumer {
            LOGGER.v("#progressConsumer args : count=$it")
            viewModelScope.launch {
                progressMutex.withLock {
                    _progress += it
                    progress.emit(0 < _progress)
                }
            }
        }

        globalChannelConsumer.exceptionConsumer = GlobalChannelConsumer.Consumer {
            LOGGER.v("#exceptionConsumer args : exception=$it", it)
            viewModelScope.launch {
                errorMutex.withLock {
                    if (null == error.value) {
                        error.emit(it)
                    } else {
                        errorQueue.add(it)
                    }
                }
            }
        }
    }

    fun onClearError() {
        LOGGER.d("#onClearError called.")

        viewModelScope.launch {
            errorMutex.withLock {
                error.emit(null)
                if (errorQueue.isNotEmpty()) {
                    delay(70L)
                    error.emit(errorQueue.removeAt(0))
                }
            }
        }
    }

    override fun toString() = "GlobalHeaderViewModel(globalChannelConsumer=$globalChannelConsumer, " +
            "progressMutex=$progressMutex, _progress=$_progress, progress=${progress.value}, " +
            "errorMutex=$errorMutex, errorQueue=$errorQueue, error=${error.value})"
}
