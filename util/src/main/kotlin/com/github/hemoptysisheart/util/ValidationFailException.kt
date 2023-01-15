package com.github.hemoptysisheart.util

class ValidationFailException(
    message: String? = null,
    cause: Throwable? = null,
    enableSuppression: Boolean = false,
    writableStackTrace: Boolean = false
) : Exception(message, cause, enableSuppression, writableStackTrace)
