package com.github.hemoptysisheart.util

import com.github.hemoptysisheart.util.NumberValidators.LONG_NOT_NEGATIVE_VALIDATOR
import com.github.hemoptysisheart.util.support.RANDOM
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import mu.KotlinLogging

class NumberValidatorsTest : BehaviorSpec({
    val logger = KotlinLogging.logger { }

    given("LONG_NOT_NEGATIVE_VALIDATOR에") {
        `when`("-1을 검사하면") {
            val e = shouldThrowExactly<ValidationFailException> { LONG_NOT_NEGATIVE_VALIDATOR.validate(-1L) }
            logger.info("[WHEN] e=$e", e)

            then("검사에 실패한다.") {
                e.shouldNotBeNull()
                e.message shouldContain "value=-1"
            }
        }

        `when`("0을 검사하면") {
            val result = LONG_NOT_NEGATIVE_VALIDATOR.validate(0L)
            logger.info("[WHEN] result=$result")

            then("검사에 통과한다.") {
                result shouldBe 0L
            }
        }

        `when`("1을 검사하면") {
            val result = LONG_NOT_NEGATIVE_VALIDATOR.validate(1L)
            logger.info("[WHEN] result=$result")

            then("검사에 통과한다.") {
                result shouldBe 1L
            }
        }

        and("임의의 양의 정수를") {
            repeat(1000) {
                val target = RANDOM.nextLong(1L, Long.MAX_VALUE)
                logger.info("[GIVEN] target=$target")

                `when`("검사하면") {
                    val result = LONG_NOT_NEGATIVE_VALIDATOR.validate(target)
                    logger.info("[WHEN] result=$result")

                    then("검사에 통과한다.") {
                        result shouldBe target
                    }
                }
            }
        }

        and("임의의 음의 정소를") {
            repeat(1000) {
                val target = RANDOM.nextLong(Long.MIN_VALUE, 0L)
                logger.info("[GIVEN] target=$target")

                `when`("검사하면") {
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
})
