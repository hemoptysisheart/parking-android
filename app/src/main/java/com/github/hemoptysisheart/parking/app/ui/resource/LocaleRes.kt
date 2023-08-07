package com.github.hemoptysisheart.parking.app.ui.resource

import androidx.annotation.StringRes
import com.github.hemoptysisheart.parking.core.R
import com.github.hemoptysisheart.parking.core.domain.common.NullLocale
import com.github.hemoptysisheart.parking.core.domain.common.SystemLocale
import com.github.hemoptysisheart.parking.domain.common.Locale

/**
 * [Locale]용 리소스 정보.
 */
enum class LocaleRes(
        val locale: Locale,
        @StringRes val localeLabel: Int,
        @StringRes val languageLabel: Int
) {
    NULL(NullLocale, R.string.domain_locale_null_locale_label, R.string.domain_locale_null_language_label),
    SYSTEM(SystemLocale, R.string.domain_locale_system_locale_label, R.string.domain_locale_system_language_label);

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)

        operator fun get(locale: Locale) = values().first { it.locale == locale }
    }
}
