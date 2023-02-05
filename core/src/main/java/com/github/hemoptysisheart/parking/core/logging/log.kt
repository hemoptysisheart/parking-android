@file:Suppress("NOTHING_TO_INLINE")

package com.github.hemoptysisheart.parking.core.logging

import android.util.Log

/**
 * 메서드 호출을 인자와 함께 [Log.VERBOSE] 로그 출력.
 */
inline fun logArgs(tag: String, method: String, vararg args: Pair<String, Any?>) {
    Log.v(
        tag,
        "#$method args : " + args.joinToString(", ") { "${it.first}=${it.second}" }
    )
}

/**
 * 메서드 호출을 인자와 함께 [Log.DEBUG] 로그 출력.
 */
inline fun logArgsD(tag: String, method: String, vararg args: Pair<String, Any?>) {
    Log.d(
        tag,
        "#$method args : " + args.joinToString(", ") { "${it.first}=${it.second}" }
    )
}

/**
 * setter 로그 출력. [Log.VERBOSE] 레벨 사용.
 */
inline fun logSet(tag: String, property: String, value: Any?) {
    Log.v(tag, "#$property set : $value")
}

/**
 * 변수를 로그로 출력. [Log.DEBUG] 레벨 사용.
 */
inline fun logVars(tag: String, method: String, vararg variables: Pair<String, Any?>) {
    Log.d(
        tag,
        "#$method : " + variables.joinToString(", ") { "${it.first}=${it.second}" }
    )
}
