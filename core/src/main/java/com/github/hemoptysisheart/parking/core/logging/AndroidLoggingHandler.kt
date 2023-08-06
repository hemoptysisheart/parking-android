package com.github.hemoptysisheart.parking.core.logging

import android.util.Log
import java.util.logging.Handler
import java.util.logging.Level
import java.util.logging.LogManager
import java.util.logging.LogRecord

class AndroidLoggingHandler : Handler() {
    companion object {
        fun setup() {
            val rootLogger = LogManager.getLogManager().getLogger("")
            for (handler in rootLogger.handlers) {
                rootLogger.removeHandler(handler)
            }
            rootLogger.addHandler(AndroidLoggingHandler())
            rootLogger.level = Level.FINE
        }
    }

    override fun isLoggable(record: LogRecord?): Boolean =
            super.isLoggable(record) // && BuildConfig.DEBUG

    override fun close() {
        // ignore
    }

    override fun flush() {
        // ignore
    }

    override fun publish(record: LogRecord) {
        val tag = record.loggerName
        val level = getAndroidLevel(record.level)
        val message = record.thrown?.let { thrown ->
            "${record.message}: ${Log.getStackTraceString(thrown)}"
        } ?: record.message

        try {
            Log.println(level, tag, message)
        } catch (e: Exception) {
            Log.e(this.javaClass.simpleName, "Error logging message", e)
        }
    }

    private fun getAndroidLevel(level: Level): Int =
            when (level.intValue()) {
                Level.SEVERE.intValue() -> Log.ERROR
                Level.WARNING.intValue() -> Log.WARN
                Level.INFO.intValue() -> Log.INFO
                Level.FINE.intValue() -> Log.DEBUG
                Level.FINEST.intValue() -> Log.VERBOSE
                else -> Log.DEBUG
            }
}
