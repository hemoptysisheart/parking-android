package com.github.hemoptysisheart.parking.core.domain.common

sealed interface Locale : com.github.hemoptysisheart.parking.domain.common.Locale

/**
 * 장소 지정 안함.
 */
object NullLocale : Locale {
    override val locale: java.util.Locale? = null
}

/**
 * OS 로케일.
 */
object SystemLocale : Locale {
    override val locale: java.util.Locale
        get() = java.util.Locale.getDefault()
}

/**
 * 위치 기반 장소.
 */
object LocationLocale : Locale {
    override val locale: java.util.Locale
        get() = TODO("Not yet implemented")
}

/**
 * 지역.
 */
enum class Locales(
        override val locale: java.util.Locale
) : Locale {
    KOREA(java.util.Locale.KOREA),
    JAPAN(java.util.Locale.JAPAN);

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)

        operator fun get(locale: java.util.Locale) = values().first { locale == it.locale }
    }
}

/**
 * 언어
 */
enum class Languages(
        val language: java.util.Locale
) : Locale {
    KOREAN(java.util.Locale.KOREAN),
    JAPANESE(java.util.Locale.JAPANESE);

    override val locale = language

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)

        operator fun get(language: java.util.Locale) = values().first { language == it.language }
    }
}

fun Locale.parse(name: String?): Locale = when (name) {
    null,
    "",
    "null" -> NullLocale

    "SYSTEM" -> SystemLocale

    else -> Locales[name]
}
