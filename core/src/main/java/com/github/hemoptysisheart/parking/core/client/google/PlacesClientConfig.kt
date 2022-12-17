package com.github.hemoptysisheart.parking.core.client.google

import java.util.*

@Suppress("MemberVisibilityCanBePrivate")
class PlacesClientConfig(
    /**
     * Places API 키.
     */
    private val key: String,
    /**
     * 검색에 사용할 기본 언어. [Locale.language]를 사용한다.
     * [영어가 아닌 언어로 Google Maps Platform 제품을 표시하려면 어떻게 해야 하나요?](https://developers.google.com/maps/faq#languagesupport) 참조.
     */
    val locale: Locale = Locale.getDefault()
) {
    override fun toString() = "${PlacesClientConfig::class.simpleName}(key=[ PROTECTED ], locale=$locale)"
}
