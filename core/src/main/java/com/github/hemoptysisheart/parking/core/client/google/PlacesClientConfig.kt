package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.util.TimeProvider
import com.github.hemoptysisheart.util.TruncatedTimeProvider
import java.net.URL
import java.util.*

@Suppress("MemberVisibilityCanBePrivate")
class PlacesClientConfig(
    /**
     * Places API 키.
     */
    val key: String,

    val endpoint: URL = URL(DEFAULT_ENDPOINT),
    /**
     * 검색에 사용할 기본 언어. [Locale.language]를 사용한다.
     * [영어가 아닌 언어로 Google Maps Platform 제품을 표시하려면 어떻게 해야 하나요?](https://developers.google.com/maps/faq#languagesupport) 참조.
     */
    val locale: Locale = Locale.getDefault(),
    /**
     * 사용자가 명시적으로 사용할 언어를 지정하지 않은 경우, 기본 언어를 사용할지 여부.
     * `true`면 [locale]를 사용한다.
     */
    val useDefaultLocale: Boolean = false,
    val timeProvider: TimeProvider = TruncatedTimeProvider(),
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

    override fun toString() = "${PlacesClientConfig::class.simpleName}(key=[ PROTECTED ], endpoint=$endpoint, " +
            "locale=$locale, useDefaultLocale=$useDefaultLocale, timeProvider=$timeProvider, debug=$debug)"
}
