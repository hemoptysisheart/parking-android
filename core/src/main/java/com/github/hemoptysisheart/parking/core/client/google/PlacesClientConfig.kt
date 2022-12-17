package com.github.hemoptysisheart.parking.core.client.google

import java.net.URL
import java.util.*

@Suppress("MemberVisibilityCanBePrivate")
class PlacesClientConfig(
    val endpoint: URL = URL(DEFAULT_ENDPOINT),
    /**
     * Places API 키.
     */
    val key: String,
    /**
     * 검색에 사용할 기본 언어. [Locale.language]를 사용한다.
     * [영어가 아닌 언어로 Google Maps Platform 제품을 표시하려면 어떻게 해야 하나요?](https://developers.google.com/maps/faq#languagesupport) 참조.
     */
    val locale: Locale = Locale.getDefault(),
    val debug: Boolean = false
) {
    companion object {
        const val DEFAULT_ENDPOINT = "https://maps.googleapis.com"
    }

    init {
        if (key.isEmpty()) {
            throw IllegalArgumentException("key is empty.")
        }
    }

    override fun toString() =
        "${PlacesClientConfig::class.simpleName}(endpoint=$endpoint, key=[ PROTECTED ], locale=$locale, debug=$debug)"
}
