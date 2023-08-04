package com.github.hemoptysisheart.util

/**
 * 리포트(데이터)를 발행자와 리포트 구독자를 중계한다.
 *
 * 리포트를 발행하면 모든 구독자의 `block`을 실행한다.
 */
interface Reporter<T> {
    fun interface Subscriber<T> {
        suspend operator fun invoke(report: T)
    }

    /**
     * 리포트 발행.
     *
     * @param report 리포트(데이터). immutable.
     */
    suspend fun publish(report: T)

    /**
     * @throws IllegalArgumentException 이미 등록된 `key`일 때.
     * @see removeSubscriber
     */
    @Throws(IllegalArgumentException::class)
    suspend fun addSubscriber(key: Any, subscriber: Subscriber<T>)

    /**
     * @return 등록되어있던 `block`. 없으면 `null`.
     * @see addSubscriber `block` 인자를 반환한다.
     */
    suspend fun removeSubscriber(key: Any): Subscriber<T>?
}
