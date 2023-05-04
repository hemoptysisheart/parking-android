package com.github.hemoptysisheart.parking.core.client.google

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.string.shouldBeEmpty
import mu.KotlinLogging

class MapsClientImplTest : StringSpec({
    val logger = KotlinLogging.logger { }

    "sample" {
        val list = listOf<String>()
        logger.info("[GIVEN] list=$list")

        val text = list.joinToString("|", "", "")
        val nullString: String? = null
        logger.info("[WHEN] text=$text")
        logger.info("[WHEN] nullString=$nullString")

        text.shouldBeEmpty()
    }
})
