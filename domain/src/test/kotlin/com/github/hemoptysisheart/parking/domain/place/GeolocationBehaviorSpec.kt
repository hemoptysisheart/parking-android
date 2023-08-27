package com.github.hemoptysisheart.parking.domain.place

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import mu.KotlinLogging

class GeolocationBehaviorSpec : BehaviorSpec() {
    private val logger = KotlinLogging.logger { }

    init {
        table(
                headers("string", "latitude", "longitude"),
                row("0.0,0.0", 0.0, 0.0),
                row("90.0,180.0", 90.0, 180.0),
                row("-90.0,-180.0", -90.0, -180.0),
                row("1.2,3.4", 1.2, 3.4)
        ).forAll { string, latitude, longitude ->
            given("좌표 문자열을(string=$string)") {
                logger.info("[GIVEN] string=$string, latitude=$latitude, longitude=$longitude")

                `when`("파싱하면") {
                    val geolocation = Geolocation.parse(string)
                    logger.info("[WHEN] geolocation=$geolocation")

                    then("예상 결과를 반환한다.") {
                        geolocation.latitude shouldBe latitude
                        geolocation.longitude shouldBe longitude
                    }
                }
            }
        }
    }
}
