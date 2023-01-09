package com.github.hemoptysisheart.parking.core.model.support

import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.scopes.BehaviorSpecRootScope

@Suppress("MemberVisibilityCanBePrivate")
open class BehaviorSpec : io.kotest.core.spec.style.BehaviorSpec() {
    init {
        afterEach { init() }
    }

    /**
     * 테스트 스펙을 재설정한다.
     * [Spec.beforeTest], [Spec.beforeAny]가 [BehaviorSpecRootScope]를 구분하지 않기 때문에 추가.
     */
    open fun init() {}
}