package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.client.google.PlacesClient
import com.github.hemoptysisheart.parking.core.client.google.dto.NearbySearchParams
import com.github.hemoptysisheart.parking.core.client.google.dto.NearbySearchResult
import com.github.hemoptysisheart.parking.core.client.google.dto.PlaceDto
import com.github.hemoptysisheart.parking.core.client.google.dto.ResultMeta
import com.github.hemoptysisheart.parking.core.model.data.GoogleSearchResultItem
import com.github.hemoptysisheart.parking.core.model.support.BehaviorSpec
import com.github.hemoptysisheart.parking.core.model.support.RANDOM
import com.github.hemoptysisheart.parking.core.model.support.TIME_PROVIDER
import com.github.hemoptysisheart.parking.core.model.support.randomString
import com.github.hemoptysisheart.parking.domain.SimpleLocation
import com.github.hemoptysisheart.util.truncateToMillis
import io.kotest.common.runBlocking
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import mu.KotlinLogging
import org.apache.commons.lang3.RandomStringUtils.random
import java.time.Instant
import java.util.*

class PlaceModelImplSpec : BehaviorSpec() {
    private val logger = KotlinLogging.logger { }

    private lateinit var model: PlaceModel
    private lateinit var placesClient: PlacesClient

    init {
        init()

        given("빈 문자열이 아닌 임의의 검색어와 임의의 위치로") {
            val query = randomString(1, 50)
            val location = SimpleLocation(1L, RANDOM.nextDouble(-90.0, 90.0), RANDOM.nextDouble(-180.0, 180.0))
            logger.info("[GIVEN] query=$query, location=$location")

            val params = NearbySearchParams(
                location.longitude,
                location.latitude,
                keyword = query
            )
            val place = PlaceDto(
                placeId = "${UUID.randomUUID()}",
                name = "name #${random(5)}",
                vicinity = "vicinity #${random(6)}"
            )
            val clientResult = NearbySearchResult(
                ResultMeta(params, Instant.now().truncateToMillis().minusSeconds(1), Instant.now()),
                listOf(place)
            )
            coEvery {
                placesClient.nearBy(any(), any())
            } returns clientResult

            `when`("장소를 검색하면") {
                val actual = runBlocking { model.search(query, location) }
                logger.info("[WHEN] actual=$actual")

                then("가짜 검색결과를 포함한 결과를 반환한다.") {
                    actual.list.size shouldBe 1
                    with(actual.list[0] as GoogleSearchResultItem) {
                        name shouldBe place.name
                        address shouldBe place.vicinity
                        this.place shouldBe place
                    }
                }
            }
        }
    }

    override fun init() {
        placesClient = mockk()
        model = PlaceModelImpl(TIME_PROVIDER, placesClient)
        logger.info("[RESET] placesClient=$placesClient")
    }
}