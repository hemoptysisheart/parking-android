package com.github.hemoptysisheart.parking.domain.common

import com.github.hemoptysisheart.util.ToSimpleString

/**
 * 앱 내부 데이터 중, [id]로 관리할 수 있는 종류.
 */
interface Object : ToSimpleString {
    val id: Identifier
}