package com.github.hemoptysisheart.util

/**
 * [Any.toString]이 인스턴스의 전체 정보를 제공하는 역할을 맡고, 간략한 핵심 데이터만 제공할 수 있는 수단을 제공한다.
 */
interface ToSimpleString {
    /**
     * 요약한 인스턴스 핵심 정보.
     */
    fun toSimpleString(): String
}