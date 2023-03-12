package com.github.hemoptysisheart.util

/**
 * 초기화가 필요한 인스턴스용 초기화 정보 제공 인터페이스.
 */
interface InitializeRequired<P> {
    /**
     * 초기화 되었는가?
     * `true`면 초기화 완료.
     */
    val initialized: Boolean

    /**
     * 초기화 하기.
     *
     * @param params 초기화에 필요한 정보. 특정 시점에 초기화가 가능한 경우라서 추가정보가 필요없는 경우에는 `null`.
     * @throws IllegalStateException 이미 초기화 된 경우.
     */
    @Throws(IllegalStateException::class)
    fun initialize(params: P? = null)
}