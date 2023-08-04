package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.util.AndroidMessageException
import com.github.hemoptysisheart.util.BlockingReporter

/**
 * 간단한 에러 메시지를 공통 처리하가 위한 리포터.
 */
class AndroidMessageExceptionReporter : BlockingReporter<AndroidMessageException>()