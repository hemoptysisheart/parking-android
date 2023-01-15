package com.github.hemoptysisheart.domain

import java.util.logging.Level.*
import java.util.logging.Logger

fun Logger.v(message: String) {
    if (isLoggable(FINER) || isLoggable(FINEST)) {
        log(FINER, message)
    }
}

fun Logger.v(message: String, e: Exception) {
    if (isLoggable(FINER) || isLoggable(FINEST)) {
        log(FINER, message, e)
    }
}

fun Logger.v(message: () -> String) {
    if (isLoggable(FINER) || isLoggable(FINEST)) {
        log(FINER, message())
    }
}

fun Logger.v(e: Exception, message: () -> String) {
    if (isLoggable(FINER) || isLoggable(FINEST)) {
        log(FINER, message(), e)
    }
}

fun Logger.d(message: String) {
    if (isLoggable(CONFIG) || isLoggable(FINE)) {
        log(CONFIG, message)
    }
}

fun Logger.d(message: String, e: Exception) {
    if (isLoggable(CONFIG) || isLoggable(FINE)) {
        log(CONFIG, message, e)
    }
}

fun Logger.d(message: () -> String) {
    if (isLoggable(CONFIG) || isLoggable(FINE)) {
        log(CONFIG, message())
    }
}

fun Logger.d(e: Exception, message: () -> String) {
    if (isLoggable(CONFIG) || isLoggable(FINE)) {
        log(CONFIG, message(), e)
    }
}

fun Logger.i(message: String) {
    if (isLoggable(INFO)) {
        log(INFO, message)
    }
}

fun Logger.i(message: String, e: Exception) {
    if (isLoggable(INFO)) {
        log(INFO, message, e)
    }
}

fun Logger.i(message: () -> String) {
    if (isLoggable(INFO)) {
        log(INFO, message())
    }
}

fun Logger.i(e: Exception, message: () -> String) {
    if (isLoggable(INFO)) {
        log(INFO, message(), e)
    }
}

fun Logger.w(message: String) {
    log(WARNING, message)
}

fun Logger.w(message: String, e: Exception) {
    log(WARNING, message, e)
}

fun Logger.w(message: () -> String) {
    log(WARNING, message())
}

fun Logger.w(e: Exception, message: () -> String) {
    log(WARNING, message(), e)
}

fun Logger.e(message: String) {
    log(SEVERE, message)
}

fun Logger.e(message: String, e: Exception) {
    log(SEVERE, message, e)
}

fun Logger.e(message: () -> String) {
    log(SEVERE, message())
}

fun Logger.e(e: Exception, message: () -> String) {
    log(SEVERE, message(), e)
}

val Any.logger: Logger
    get() = Logger.getLogger(this::class.simpleName)