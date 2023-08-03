package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.ProgressReporter
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.util.TimeProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

open class BaseViewModel : ViewModel(), DefaultLifecycleObserver {
    private val progressCounter = AtomicInteger()
    protected val logger = AndroidLogger(this::class)

    @Inject
    lateinit var timeProvider: TimeProvider

    @Inject
    lateinit var progressReporter: ProgressReporter

    fun launch(
        progress: Boolean = false,
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        logger.d("#launch args : progress=$progress, context=$context, start=$start, block=$block")

        val launchKey = UUID.randomUUID()
        return viewModelScope.launch(context, start) {
            try {
                if (progress) {
                    logger.v("#launch increase progress : key=$launchKey, now=${timeProvider.instant()}")
                    progressCounter.incrementAndGet()
                    progressReporter.publish(1)
                }

                block()
            } finally {
                if (progress) {
                    logger.v("#launch decrease progress : key=$launchKey, now=${timeProvider.instant()}")
                    progressCounter.decrementAndGet()
                    progressReporter.publish(-1)
                }
            }
        }
    }

    override fun onCleared() {
        logger.d("#onCleared called.")
        super.onCleared()

        viewModelScope.launch {
            progressReporter.publish(-progressCounter.get())
        }
    }
}
