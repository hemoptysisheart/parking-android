package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.AndroidMessageExceptionReporter
import com.github.hemoptysisheart.parking.core.model.ProgressReporter
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
    private val launchReporter: ProgressReporter,
    private val androidMessageExceptionReporter: AndroidMessageExceptionReporter
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
        viewModelScope.launch {
            launchReporter.addSubscriber(GlobalHeaderViewModel::class) {
                progressMutex.withLock {
                    _progress += it
                    LOGGER.v("#launchReporter.Subscriber publish $it : _progress=$_progress")
                    progress.emit(0 < _progress)
                }
            }

            androidMessageExceptionReporter.addSubscriber(GlobalHeaderViewModel::class) {
                errorMutex.withLock {
                    if (null == error.value) {
                        error.emit(it)
                    } else {
                        errorQueue.add(it)
                    }
                    LOGGER.v("#androidMessageExceptionReporter.Subscriber : error=${error.value}, errorQueue=$errorQueue")
                }
            }
        }
    }

    override fun onCleared() {
        LOGGER.d("#onCleared called.")
        super.onCleared()

        viewModelScope.launch {
            launchReporter.removeSubscriber(GlobalHeaderViewModel::class)
        }
    }

    fun onClearError() {
        LOGGER.d("#onClearError called.")

        viewModelScope.launch {
            errorMutex.withLock {
                error.emit(null)
                if (errorQueue.isNotEmpty()) {
                    delay(10L)
                    error.emit(errorQueue.removeAt(0))
                }
            }
        }
    }
}
