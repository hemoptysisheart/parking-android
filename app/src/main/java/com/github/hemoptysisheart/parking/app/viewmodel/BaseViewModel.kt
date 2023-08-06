package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.GlobalChannel
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.core.util.AndroidMessageException
import com.github.hemoptysisheart.util.TimeProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.UUID
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

open class BaseViewModel : ViewModel(), DefaultLifecycleObserver {
    abstract class ViewModelet(
            val base: BaseViewModel,
            val key: UUID = UUID.randomUUID()!!
    ) {
        protected fun launch(
                progress: Boolean = false,
                context: CoroutineContext = EmptyCoroutineContext,
                start: CoroutineStart = CoroutineStart.DEFAULT,
                block: suspend CoroutineScope.() -> Unit
        ): Job = base.launch(progress, context, start, block)
    }

    private val progressCounter = AtomicInteger()
    protected val logger = AndroidLogger(this::class)

    @Inject
    lateinit var timeProvider: TimeProvider

    @Inject
    lateinit var globalChannel: GlobalChannel

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
                    globalChannel.reportProgress(1)
                }

                block()
            } catch (e: AndroidMessageException) {
                logger.w("#launch error occur.", e)
                globalChannel.reportException(e)
            } finally {
                if (progress) {
                    logger.v("#launch decrease progress : key=$launchKey, now=${timeProvider.instant()}")
                    progressCounter.decrementAndGet()
                    globalChannel.reportProgress(-1)
                }
            }
        }
    }

    override fun onCleared() {
        logger.d("#onCleared called.")
        super.onCleared()

        viewModelScope.launch {
            globalChannel.reportProgress(-progressCounter.get())
        }
    }
}
