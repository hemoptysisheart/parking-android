package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.GlobalChannel
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.core.util.AndroidMessageException
import com.github.hemoptysisheart.util.TimeProvider
import com.github.hemoptysisheart.util.ToSimpleString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.Instant
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
         * [BaseViewModel.launchCompleteAt]를 대행한다.
         *
         * [launch]가 완료된 시각. 더 정확한 시각을 지정하기 위해 [timeProvider]를 사용하지 않고 직접 [Instant.now]를 사용한다. 시스템 시계가 변경됐을 가능성이 없기 때문에
         * 시각 정보를 사용해서는 안되고, 단순히 증가하는 값으로 변경되었다는 사실만을 사용해야 한다.
         */
        protected val launchCompleteAt = base.launchCompleteAt

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

    /**
     * UI(Compose)에는 읽기 인터페이스만 노출하기 위한 래퍼.
     */
    class VmProperty<T>(
            val name: String,
            val initValue: T
    ) : ToSimpleString {
        protected val _value = MutableStateFlow(initValue)
        val value: StateFlow<T> = _value

        suspend fun set(value: T) {
            _value.emit(value)
        }

        override fun toSimpleString() = "$name=${_value.value}"

        override fun toString(): String = "initValue=$initValue, _value=${_value.value}"
    }

    private val progressCounter = AtomicInteger()

    protected val logger = AndroidLogger(this::class)

    @Inject
    lateinit var timeProvider: TimeProvider

    @Inject
    lateinit var globalChannel: GlobalChannel

    /**
     * [launch]가 완료된 시각. 더 정확한 시각을 지정하기 위해 [timeProvider]를 사용하지 않고 직접 [Instant.now]를 사용한다. 시스템 시계가 변경됐을 가능성이 없기 때문에 시각
     * 정보를 사용해서는 안되고, 단순히 증가하는 값으로 변경되었다는 사실만을 사용해야 한다.
     */
    private val _launchCompleteAt = MutableStateFlow(Instant.now())

    /**
     * [launch]가 완료된 시각. 더 정확한 시각을 지정하기 위해 [timeProvider]를 사용하지 않고 직접 [Instant.now]를 사용한다. 시스템 시계가 변경됐을 가능성이 없기 때문에 시각
     * 정보를 사용해서는 안되고, 단순히 증가하는 값으로 변경되었다는 사실만을 사용해야 한다.
     */
    protected val launchCompleteAt: StateFlow<Instant> = _launchCompleteAt

    /**
     * [viewModelScope]로 코루틴을 실행한다.
     *
     * @param progress 코루틴 실행중 프로그레스 인디케이터 표시 여부.
     * @param requestSignal 코루틴 실행이 끝나면 [launchCompleteAt] 갱신으로 신호를 보내도록 요청한다.
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
                    _launchCompleteAt.emit(Instant.now())
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
