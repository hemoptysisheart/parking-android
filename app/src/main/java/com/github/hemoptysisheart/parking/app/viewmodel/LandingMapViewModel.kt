package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.LifecycleOwner
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

/**
 * [랜딩 맵](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-645)
 */
@HiltViewModel
class LandingMapViewModel @Inject constructor() : BaseViewModel() {
    companion object {
        private val LOGGER = AndroidLogger(LandingMapViewModel::class)
    }

    private val counter = AtomicInteger()
    val count = MutableStateFlow(0)

    init {
        LOGGER.i("#init called.")
    }

    override fun onResume(owner: LifecycleOwner) {
        LOGGER.d("#onResume args : owner=$owner")
        super.onResume(owner)

        launch {
            count.emit(counter.incrementAndGet())
        }
    }

    override fun onCleared() {
        LOGGER.d("#onCleared called.")
        super.onCleared()
    }
}
