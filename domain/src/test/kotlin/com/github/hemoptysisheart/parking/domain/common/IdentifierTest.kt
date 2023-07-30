package com.github.hemoptysisheart.parking.domain.common

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.nulls.shouldNotBeNull
import mu.KotlinLogging

class IdentifierTest : BehaviorSpec() {
    private val logger = KotlinLogging.logger { }

    private val type = object : Type {}

    init {
        listOf(
            ""
        ).forAll { key ->
            given("사용 불가능한 키(key=$key)로") {
                logger.info("[GIVEN] key=$key")

                `when`("인스턴스를 만들면") {
                    val e = shouldThrowExactly<IllegalArgumentException> { Identifier(type, key) }
                    logger.info("[WHEN] e=$e")

                    then("에러가 발생한다.") {
                        e.shouldNotBeNull()
                    }
                }
            }
        }
    }
}
