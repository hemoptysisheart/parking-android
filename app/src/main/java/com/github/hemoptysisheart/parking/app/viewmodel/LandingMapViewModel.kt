package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.LifecycleOwner
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

/**
 * [랜딩 맵](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-645)
 */
@HiltViewModel
class LandingMapViewModel @Inject constructor() : BaseViewModel() {
    private val showCounter = AtomicInteger()
    val count = MutableStateFlow(0)

    init {
        logger.i("#init called.")
    }

    fun onProgress() {
        logger.d("#onProgress called.")

        launch(true) {
            delay(ThreadLocalRandom.current().nextLong(1_000, 10_000))
        }
    }

    override fun onResume(owner: LifecycleOwner) {
        logger.d("#onResume args : owner=$owner")
        super.onResume(owner)

        launch {
            count.emit(showCounter.incrementAndGet())
        }
    }
}
