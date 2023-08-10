package com.github.hemoptysisheart.parking.core.domain.common

import com.github.hemoptysisheart.parking.core.util.AndroidLogger

sealed interface Locale : com.github.hemoptysisheart.parking.domain.common.Locale {
    companion object {
        private val LOGGER = AndroidLogger(Locale::class)

        const val NAME_NULL_LOCALE = "null"

        const val NAME_SYSTEM_LOCALE = "system"

        operator fun get(name: String): Locale {
            LOGGER.v("#get args : name=$name")
            val locale = when (name) {
                NAME_NULL_LOCALE -> NullLocale
                NAME_SYSTEM_LOCALE -> SystemLocale
                else -> Locales[name]
            }
            LOGGER.v("#get return : $locale")
            return locale
        }
    }
}

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
