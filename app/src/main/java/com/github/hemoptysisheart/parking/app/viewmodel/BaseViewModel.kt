package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.GlobalChannel
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.core.util.AndroidMessageException
import com.github.hemoptysisheart.util.TimeProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * [ViewModel] 확장 기능.
 */
open class BaseViewModel : ViewModel(), DefaultLifecycleObserver {
    /**
     * 여러개의 속성이 긴밀하게 연동되는 UI를 구현해야 할 때, 관련 기능을 묶어서 구현할 수 있도록 도와주는 [ViewModel] 유틸리티 클래스.
     */
    abstract class ViewModelet(
            val base: BaseViewModel,
            val key: UUID = UUID.randomUUID()!!
    ) {
        /**
         * [BaseViewModel.launchSignal]를 대행한다.
         */
        protected val launchSignal = base.launchSignal

        /**
         * [BaseViewModel.launch]를 대행한다.
         */
        protected fun launch(
                progress: Boolean = false,
                requestSignal: Boolean = false,
                context: CoroutineContext = EmptyCoroutineContext,
                start: CoroutineStart = CoroutineStart.DEFAULT,
                block: suspend CoroutineScope.() -> Unit
        ): Job = base.launch(progress, requestSignal, context, start, block)

        override fun toString() = "base=$base, key=$key"
    }

    private val progressCounter = AtomicInteger()

    protected val logger = AndroidLogger(this::class)

    @Inject
    lateinit var timeProvider: TimeProvider

    @Inject
    lateinit var globalChannel: GlobalChannel

    private val _launchSignal = MutableStateFlow(UUID.randomUUID())
    protected val launchSignal: StateFlow<UUID> = _launchSignal

    /**
     * [viewModelScope]로 코루틴을 실행한다.
     *
     * @param progress 코루틴 실행중 프로그레스 인디케이터 표시 여부.
     * @param requestSignal 코루틴 실행이 끝나면 [launchSignal] 갱신으로 신호를 보내도록 요청한다.
     */
    protected fun launch(
            progress: Boolean = false,
            requestSignal: Boolean = false,
            context: CoroutineContext = EmptyCoroutineContext,
            start: CoroutineStart = CoroutineStart.DEFAULT,
            block: suspend CoroutineScope.() -> Unit
    ): Job {
        logger.d("#launch args : progress=$progress, context=$context, start=$start, block=$block")

        val launchKey = UUID.randomUUID()
        return viewModelScope.launch(context, start) {
            try {
                if (progress) {
                    logger.v("#launch increase progress : key=$launchKey")
                    progressCounter.incrementAndGet()
                    globalChannel.reportProgress(1)
                }

                block()
            } catch (e: AndroidMessageException) {
                logger.w("#launch exception occurred.", e)
                globalChannel.reportException(e)
            } catch (e: Exception) {
                logger.w("#launch error occurred.", e)
                // TODO report error.
            } finally {
                if (progress) {
                    logger.v("#launch decrease progress : key=$launchKey")
                    progressCounter.decrementAndGet()
                    globalChannel.reportProgress(-1)
                }
                if (requestSignal) {
                    _launchSignal.emit(UUID.randomUUID())
                }
            }
        }
    }

    override fun onCreate(owner: LifecycleOwner) {
        logger.d("#onCreate args : owner=$owner")
        super.onCreate(owner)
    }

    override fun onStart(owner: LifecycleOwner) {
        logger.d("#onStart args : owner=$owner")
        super.onStart(owner)
    }

    override fun onResume(owner: LifecycleOwner) {
        logger.d("#onResume args : owner=$owner")
        super.onResume(owner)
    }

    override fun onPause(owner: LifecycleOwner) {
        logger.d("#onPause args : owner=$owner")
        super.onPause(owner)
    }

    override fun onStop(owner: LifecycleOwner) {
        logger.d("#onStop args : owner=$owner")
        super.onStop(owner)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        logger.d("#onDestroy args : owner=$owner")
        super.onDestroy(owner)
    }

    override fun onCleared() {
        logger.d("#onCleared called.")
        super.onCleared()

        viewModelScope.launch {
            globalChannel.reportProgress(-progressCounter.get())
        }
    }
}
