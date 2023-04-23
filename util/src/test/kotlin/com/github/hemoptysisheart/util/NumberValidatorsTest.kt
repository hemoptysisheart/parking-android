package com.github.hemoptysisheart.util

import com.github.hemoptysisheart.util.NumberValidators.LONG_NOT_NEGATIVE_VALIDATOR
import com.github.hemoptysisheart.util.support.RANDOM
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import mu.KLogger
import mu.KotlinLogging
import java.util.stream.IntStream
import kotlin.streams.toList

class NumberValidatorsTest : BehaviorSpec() {
    init {
        val logger: KLogger = KotlinLogging.logger { }

        given("-1L을") {
            `when`("LONG_NOT_NEGATIVE_VALIDATOR로 검사하면") {
                val e = shouldThrowExactly<ValidationFailException> { LONG_NOT_NEGATIVE_VALIDATOR.validate(-1L) }
                logger.info("[WHEN] e=$e", e)

                then("검사에 실패한다.") {
                    e.shouldNotBeNull()
                    e.message shouldContain "value=-1"
                }
            }
        }

        given("0L을") {
            `when`("LONG_NOT_NEGATIVE_VALIDATOR로 검사하면") {
                val result = LONG_NOT_NEGATIVE_VALIDATOR.validate(0L)
                logger.info("[WHEN] result=$result")

                then("검사에 통과한다.") {
                    result shouldBe 0L
                }
            }
        }

        given("1L을") {
            `when`("LONG_NOT_NEGATIVE_VALIDATOR로 검사하면") {
                val result = LONG_NOT_NEGATIVE_VALIDATOR.validate(1L)
                logger.info("[WHEN] result=$result")

                then("검사에 통과한다.") {
                    result shouldBe 1L
                }
            }
        }

        given("Long.MAX_VALUE를") {
            `when`("LONG_NOT_NEGATIVE_VALIDATOR로 검사하면") {
                val actual = LONG_NOT_NEGATIVE_VALIDATOR.validate(Long.MAX_VALUE)
                logger.info("[WHEN] actual=$actual")

                then("검사에 통과한다.") {
                    actual shouldBe Long.MAX_VALUE
                }
            }
        }

        given("임의의 양의 정수(Long)") {
            IntStream.range(0, 500).toList().forAll {
                val target = RANDOM.nextLong(1, Long.MAX_VALUE)

                `when`("${target}을/를 LONG_NOT_NEGATIVE_VALIDATOR로 검사하면") {
                    val result = LONG_NOT_NEGATIVE_VALIDATOR.validate(target)

                    then("검사에 통과한다.") {
                        result shouldBe target
                    }
                }
            }
        }

        given("임의의 음의 정수") {
            IntStream.range(0, 500).toList().forAll {
                val target = RANDOM.nextLong(Long.MIN_VALUE, 0L)

                `when`("${target}을/를 LONG_NOT_NEGATIVE_VALIDATOR로 검사하면") {
                    val e = shouldThrowExactly<ValidationFailException> { LONG_NOT_NEGATIVE_VALIDATOR.validate(target) }
                    logger.info("[WHEN] e=$e", e)

                    then("검사에 실패한다.") {
                        e.shouldNotBeNull()
                        e.message shouldContain "value=$target"
                    }
                }
            }
        }
    }
}
