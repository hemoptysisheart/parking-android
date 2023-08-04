package com.github.hemoptysisheart.parking.core.util

import android.content.Context
import androidx.annotation.StringRes

/**
 * 안드로이드 문자열 리소스로 상세 내용을 전달하는 예외.
 */
class AndroidMessageException(
    @StringRes val titleId: Int?,
    @StringRes val detailId: Int,
    vararg val detailArgs: Any?,
    cause: Throwable? = null
) : Exception("title=$titleId, detailId=$detailId, detailArgs=${detailArgs.contentToString()}", cause) {
    fun title(context: Context) = if (null == titleId) {
        null
    } else {
        context.getString(titleId)
    }

    fun detail(context: Context) = context.getString(detailId, *detailArgs)

    override fun toString() = "(titleId=$titleId, detailId=$detailId, detailArgs=${detailArgs.contentToString()})"
}
