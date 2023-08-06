package com.github.hemoptysisheart.util

import java.util.logging.Level
import java.util.logging.Level.FINE
import java.util.logging.Level.FINEST
import java.util.logging.Level.INFO
import java.util.logging.Level.SEVERE
import java.util.logging.Level.WARNING
import java.util.logging.Logger.getLogger
import kotlin.reflect.KClass

/**
 * [로깅 이해](https://source.android.com/docs/core/tests/debug/understanding-logging) 참조.
 *
 * - [LoggerImpl.v] -> [Level.FINEST]
 * - [LoggerImpl.d] -> [Level.FINE]
 * - [LoggerImpl.i] -> [Level.INFO]
 * - [LoggerImpl.w] -> [Level.WARNING]
 * - [LoggerImpl.e] -> [Level.SEVERE]
 */
class LoggerImpl(
        name: String
) : Logger {
    constructor(clazz: KClass<*>) : this(clazz.simpleName!!)

    val logger = getLogger(name)

    /**
     * [Level.FINEST]
     */
    override fun v(message: String) {
        if (logger.isLoggable(FINEST)) {
            logger.log(FINEST, message)
        }
    }

    /**
     * [Level.FINEST]
     */
    override fun v(message: () -> String) {
        if (logger.isLoggable(FINEST)) {
            logger.log(FINEST, message())
        }
    }

    /**
     * [Level.FINEST]
     */
    override fun v(message: String, e: Throwable) {
        if (logger.isLoggable(FINEST)) {
            logger.log(FINEST, message, e)
        }
    }

    /**
     * [Level.FINEST]
     */
    override fun v(message: () -> String, e: Throwable) {
        if (logger.isLoggable(FINEST)) {
            logger.log(FINEST, message(), e)
        }
    }

    /**
     * [Level.FINE]
     */
    override fun d(message: String) {
        if (logger.isLoggable(FINE)) {
            logger.log(FINE, message)
        }
    }

    /**
     * [Level.FINE]
     */
    override fun d(message: () -> String) {
        if (logger.isLoggable(FINE)) {
            logger.log(FINE, message())
        }
    }

    /**
     * [Level.FINE]
     */
    override fun d(message: String, e: Throwable) {
        if (logger.isLoggable(FINE)) {
            logger.log(FINE, message, e)
        }
    }

    /**
     * [Level.FINE]
     */
    override fun d(message: () -> String, e: Throwable) {
        if (logger.isLoggable(FINE)) {
            logger.log(FINE, message(), e)
        }
    }

    /**
     * [Level.INFO]
     */
    override fun i(message: String) {
        logger.log(INFO, message)
    }

    /**
     * [Level.INFO]
     */
    override fun i(message: () -> String) {
        logger.log(INFO, message())
    }

    /**
     * [Level.INFO]
     */
    override fun i(message: String, e: Throwable) {
        logger.log(INFO, message, e)
    }

    /**
     * [Level.INFO]
     */
    override fun i(message: () -> String, e: Throwable) {
        logger.log(INFO, message(), e)
    }

    /**
     * [Level.WARNING]
     */
    override fun w(message: String) {
        logger.log(WARNING, message)
    }

    /**
     * [Level.WARNING]
     */
    override fun w(message: () -> String) {
        logger.log(WARNING, message())
    }

    /**
     * [Level.WARNING]
     */
    override fun w(message: String, e: Throwable) {
        logger.log(WARNING, message, e)
    }

    /**
     * [Level.WARNING]
     */
    override fun w(message: () -> String, e: Throwable) {
        logger.log(WARNING, message(), e)
    }

    /**
     * [Level.SEVERE]
     */
    override fun e(message: String) {
        logger.log(SEVERE, message)
    }

    /**
     * [Level.SEVERE]
     */
    override fun e(message: () -> String) {
        logger.log(SEVERE, message())
    }

    /**
     * [Level.SEVERE]
     */
    override fun e(message: String, e: Throwable) {
        logger.log(SEVERE, message, e)
    }

    /**
     * [Level.SEVERE]
     */
    override fun e(message: () -> String, e: Throwable) {
        logger.log(SEVERE, message(), e)
    }

    override fun toString() = logger.toString()
}