package com.github.hemoptysisheart.util

import java.util.logging.Level.*
import java.util.logging.Logger

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.v(message: String) {
    if (isLoggable(FINER) || isLoggable(FINEST)) {
        log(FINER, message)
    }
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.v(message: String, e: Exception) {
    if (isLoggable(FINER) || isLoggable(FINEST)) {
        log(FINER, message, e)
    }
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.v(message: () -> String) {
    if (isLoggable(FINER) || isLoggable(FINEST)) {
        log(FINER, message())
    }
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.v(e: Exception, message: () -> String) {
    if (isLoggable(FINER) || isLoggable(FINEST)) {
        log(FINER, message(), e)
    }
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.d(message: String) {
    if (isLoggable(CONFIG) || isLoggable(FINE)) {
        log(CONFIG, message)
    }
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.d(message: String, e: Exception) {
    if (isLoggable(CONFIG) || isLoggable(FINE)) {
        log(CONFIG, message, e)
    }
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.d(message: () -> String) {
    if (isLoggable(CONFIG) || isLoggable(FINE)) {
        log(CONFIG, message())
    }
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.d(e: Exception, message: () -> String) {
    if (isLoggable(CONFIG) || isLoggable(FINE)) {
        log(CONFIG, message(), e)
    }
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.i(message: String) {
    if (isLoggable(INFO)) {
        log(INFO, message)
    }
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.i(message: String, e: Exception) {
    if (isLoggable(INFO)) {
        log(INFO, message, e)
    }
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.i(message: () -> String) {
    if (isLoggable(INFO)) {
        log(INFO, message())
    }
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.i(e: Exception, message: () -> String) {
    if (isLoggable(INFO)) {
        log(INFO, message(), e)
    }
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.w(message: String) {
    log(WARNING, message)
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.w(message: String, e: Exception) {
    log(WARNING, message, e)
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.w(message: () -> String) {
    log(WARNING, message())
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.w(e: Exception, message: () -> String) {
    log(WARNING, message(), e)
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.e(message: String) {
    log(SEVERE, message)
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.e(message: String, e: Exception) {
    log(SEVERE, message, e)
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.e(message: () -> String) {
    log(SEVERE, message())
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
fun Logger.e(e: Exception, message: () -> String) {
    log(SEVERE, message(), e)
}

@Deprecated("use Logger", ReplaceWith("com.github.hemoptysisheart.parking.core.util.Logger"))
val Any.logger: Logger
    get() = Logger.getLogger(this::class.simpleName)