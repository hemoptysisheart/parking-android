package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.util.BlockingReporter

/**
 * VM 사이에 프로그레스 정보 공유.
 */
class ProgressReporter : BlockingReporter<Int>()
