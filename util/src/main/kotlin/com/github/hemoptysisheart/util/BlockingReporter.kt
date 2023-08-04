package com.github.hemoptysisheart.util

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * 코루틴을 멈추고 모든 구독자에게 리포트를 전달한다.
 */
open class BlockingReporter<T> : Reporter<T> {
    private val mutex = Mutex()
    private val subscribers = mutableMapOf<Any, Reporter.Subscriber<T>>()

    override suspend fun publish(report: T) {
        mutex.withLock {
            subscribers.values.forEach {
                it(report)
            }
        }
    }

    override suspend fun addSubscriber(key: Any, subscriber: Reporter.Subscriber<T>) {
        mutex.withLock {
            if (null != subscribers[key]) {
                throw IllegalArgumentException("already exist : key=$key")
            }

            subscribers[key] = subscriber
        }
    }

    override suspend fun removeSubscriber(key: Any): Reporter.Subscriber<T>? {
        mutex.withLock {
            return subscribers.remove(key)
        }
    }
}
