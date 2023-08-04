package com.github.hemoptysisheart.parking.app.ui.support

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.core.util.AndroidMessageException

@Composable
fun AndroidMessageException.title() = titleId?.run {
    stringResource(this)
} ?: stringResource(R.string.global_header_error_default_title)

@Composable
fun AndroidMessageException.detail() = stringResource(detailId, *detailArgs.map { it ?: "null" }.toTypedArray())
