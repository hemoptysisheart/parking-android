package com.github.hemoptysisheart.parking.client.google

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import mu.KotlinLogging
import java.time.LocalTime

class DataConverterTest : BehaviorSpec() {
    private val logger = KotlinLogging.logger { }

    init {
        given("영업시각 '0000'을") {
            val text = "0000"
            logger.info("[GIVEN] ")

            `when`("파싱하면 0시 0분을 반환한다.") {
                val localTime = LocalTime.parse(
                    text,
                    com.github.hemoptysisheart.parking.client.google.data.PlaceOpeningHoursPeriodDetail.TIME_FORMATTER
                )
                logger.info("[WHEN] localTime=$localTime")

                then("파싱 성공.") {
                    localTime.hour shouldBe 0
                    localTime.minute shouldBe 0
                }
            }
        }
    }
}
