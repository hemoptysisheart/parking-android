package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.util.AndroidMessageException

interface GlobalChannel {
    /**
     * 글로벌 프로그레스 인디케이터를 표시에 반영할 가중치를 전달한다.
     *
     * @see GlobalChannelConsumer.progressConsumer
     */
    fun reportProgress(weight: Int)

    /**
     * 글로벌 에러 다이얼로그를 표시할 수 있도록 전달한다.
     *
     * @see GlobalChannelConsumer.exceptionConsumer
     */
    fun reportException(exception: AndroidMessageException)
}
