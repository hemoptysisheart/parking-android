package com.github.hemoptysisheart.parking.domain.common

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import mu.KotlinLogging
import java.util.UUID

class IdentifierTest : BehaviorSpec() {
    private val logger = KotlinLogging.logger { }

    private val type = object : Type {
        override val hostname: String = "unittest"

        override fun toString() = "unit-test"
    }

    init {
        listOf<String>(
                // TODO 빈 문자열을 불허해야 하나? 빈 문자열은 쿼리 생성할 수 없다고 해야 하나?
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

        given("toURI() : 임의의 값으로") {
            val key = "${UUID.randomUUID()}"
            val identifier = Identifier(type, key)
            logger.info("[GIVEN] key=$key, identifier=$identifier")

            `when`("URI로 변환하면") {
                val uri = identifier.toURI()
                logger.info("[WHEN] uri=$uri")

                then("변환된다.") {
                    uri.scheme shouldBe Identifier.SCHEME
                    uri.host shouldBe type.hostname
                    uri.path shouldBe "/$key"
                }
            }
        }
    }
}
