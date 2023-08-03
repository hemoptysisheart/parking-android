package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.ProgressReporter
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

@HiltViewModel
class GlobalHeaderViewModel @Inject constructor(
    private val reporter: ProgressReporter
) : ViewModel(), DefaultLifecycleObserver {
    companion object {
        private val LOGGER = AndroidLogger(GlobalHeaderViewModel::class)
    }

    private val progressMutex = Mutex()
    private var _progress = 0
    val progress = MutableStateFlow(false)

    init {
        viewModelScope.launch {
            reporter.addSubscriber(GlobalHeaderViewModel::class) {
                progressMutex.withLock {
                    _progress += it
                    LOGGER.v("#reporter.Subscriber publish $it : _progress=$_progress")
                    progress.emit(0 < _progress)
                }
            }
        }
    }

    override fun onCleared() {
        LOGGER.d("#onCleared called.")
        super.onCleared()

        viewModelScope.launch {
            reporter.removeSubscriber(GlobalHeaderViewModel::class)
        }
    }
}
