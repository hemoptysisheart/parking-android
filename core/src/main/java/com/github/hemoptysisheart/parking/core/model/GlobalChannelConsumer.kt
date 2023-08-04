package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.util.AndroidMessageException

interface GlobalChannelConsumer {
    fun interface Consumer<T> {
        operator fun invoke(t: T)
    }

    /**
     * [GlobalChannel.reportProgress]가 보고한 가중치로 글로벌 프로그레스 인디케이터를 표시할지 결정한다.
     */
    var progressConsumer: Consumer<Int>

    /**
     * [GlobalChannel.reportException]가 보고한 에러로 공용 다이얼로그를 표시한다.
     */
    var exceptionConsumer: Consumer<AndroidMessageException>
}
