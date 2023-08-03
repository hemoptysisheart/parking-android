package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.util.BlockingReporter
import javax.inject.Inject

/**
 * VM 사이에 프로그레스 정보 공유.
 */
class ProgressReporter @Inject constructor() : BlockingReporter<Int>()
