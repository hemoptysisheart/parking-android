package com.github.hemoptysisheart.parking.core.model

/**
 * 권한 정보를 제공한다.
 */
interface PermissionModel {
    /**
     * 위치정보 권한이 있으면 `true`.
     */
    val location: Boolean
}