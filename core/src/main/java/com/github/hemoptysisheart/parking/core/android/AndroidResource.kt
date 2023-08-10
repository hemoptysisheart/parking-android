package com.github.hemoptysisheart.parking.core.android

import androidx.annotation.StringRes
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * Android 리소스
 */
sealed interface AndroidResource

/**
 * 도메인 오브젝트 리소스.
 */
class DomainObjectResource(
        /**
         * 도메인 오브젝트 타입.
         */
        val type: KClass<*>,
        /**
         * 이름
         */
        @StringRes val name: Int
) : AndroidResource

class DomainPropertyResource(
        val property: KProperty<*>,
        @StringRes val name: Int
) : AndroidResource