package com.github.hemoptysisheart.parking.core.util

import android.util.Log
import com.github.hemoptysisheart.parking.core.ModuleConfig
import com.github.hemoptysisheart.parking.core.util.AndroidLogger.Level.*
import com.github.hemoptysisheart.util.Logger
import kotlin.reflect.KClass

class AndroidLogger(
        val name: String
) : Logger {
    enum class Level {
        V, D, I, W, E;
    }

    data class Option(
            val levelOverwrite: Map<Level, Level> = mapOf()
    )

    @Suppress("MemberVisibilityCanBePrivate")
    companion object {
        private var option = Option()

        const val NAME_PATTERN = "\\S+"

        val NAME_REGEX = NAME_PATTERN.toRegex()
    }

    constructor(clazz: KClass<*>) : this(clazz.simpleName!!)

    constructor(clazz: KClass<*>, vararg keys: Any) : this("${clazz.simpleName!!}@${keys.contentToString()}")

    init {
        when {
            name.isEmpty() ->
                throw IllegalArgumentException("name is empty.")

            !name.matches(NAME_REGEX) ->
                throw IllegalArgumentException("illegal name : name='$name', PATTERN='$NAME_PATTERN'")
        }
    }

    override fun v(message: String) {
        when (option.levelOverwrite[V]) {
            null,
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message)
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message)
            }

            I -> Log.i(name, message)
            W -> Log.w(name, message)
            E -> Log.e(name, message)
        }
    }

    override fun v(message: () -> String) {
        when (option.levelOverwrite[V]) {
            null,
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message())
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message())
            }

            I -> Log.i(name, message())
            W -> Log.w(name, message())
            E -> Log.e(name, message())
        }
    }

    override fun v(message: String, e: Throwable) {
        when (option.levelOverwrite[V]) {
            null,
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message, e)
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message, e)
            }

            I -> Log.i(name, message, e)
            W -> Log.w(name, message, e)
            E -> Log.e(name, message, e)
        }
    }

    override fun v(message: () -> String, e: Throwable) {
        when (option.levelOverwrite[V]) {
            null,
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message(), e)
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message(), e)
            }

            I -> Log.i(name, message(), e)
            W -> Log.w(name, message(), e)
            E -> Log.e(name, message(), e)
        }
    }

    override fun d(message: String) {
        when (option.levelOverwrite[D]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message)
            }

            null,
            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message)
            }

            I -> Log.i(name, message)
            W -> Log.w(name, message)
            E -> Log.e(name, message)
        }
    }

    override fun d(message: () -> String) {
        when (option.levelOverwrite[D]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message())
            }

            null,
            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message())
            }

            I -> Log.i(name, message())
            W -> Log.w(name, message())
            E -> Log.e(name, message())
        }
    }

    override fun d(message: String, e: Throwable) {
        when (option.levelOverwrite[D]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message, e)
            }

            null,
            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message, e)
            }

            I -> Log.i(name, message, e)
            W -> Log.w(name, message, e)
            E -> Log.e(name, message, e)
        }
    }

    override fun d(message: () -> String, e: Throwable) {
        when (option.levelOverwrite[D]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message(), e)
            }

            null,
            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message(), e)
            }

            I -> Log.i(name, message(), e)
            W -> Log.w(name, message(), e)
            E -> Log.e(name, message(), e)
        }
    }

    override fun i(message: String) {
        when (option.levelOverwrite[I]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message)
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message)
            }

            null,
            I -> Log.i(name, message)

            W -> Log.w(name, message)
            E -> Log.e(name, message)
        }
    }

    override fun i(message: () -> String) {
        when (option.levelOverwrite[I]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message())
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message())
            }

            null,
            I -> Log.i(name, message())

            W -> Log.w(name, message())
            E -> Log.e(name, message())
        }
    }

    override fun i(message: String, e: Throwable) {
        when (option.levelOverwrite[I]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message, e)
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message, e)
            }

            null,
            I -> Log.i(name, message, e)

            W -> Log.w(name, message, e)
            E -> Log.e(name, message, e)
        }
    }

    override fun i(message: () -> String, e: Throwable) {
        when (option.levelOverwrite[I]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message(), e)
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message(), e)
            }

            null,
            I -> Log.i(name, message(), e)

            W -> Log.w(name, message(), e)
            E -> Log.e(name, message(), e)
        }
    }

    override fun w(message: String) {
        when (option.levelOverwrite[W]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message)
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message)
            }

            I -> Log.i(name, message)
            null,
            W -> Log.w(name, message)

            E -> Log.e(name, message)
        }
    }

    override fun w(message: () -> String) {
        when (option.levelOverwrite[W]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message())
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message())
            }

            I -> Log.i(name, message())
            null,
            W -> Log.w(name, message())

            E -> Log.e(name, message())
        }
    }

    override fun w(message: String, e: Throwable) {
        when (option.levelOverwrite[W]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message, e)
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message, e)
            }

            I -> Log.i(name, message, e)
            null,
            W -> Log.w(name, message, e)

            E -> Log.e(name, message, e)
        }
    }

    override fun w(message: () -> String, e: Throwable) {
        when (option.levelOverwrite[W]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message(), e)
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message(), e)
            }

            I -> Log.i(name, message(), e)
            null,
            W -> Log.w(name, message(), e)

            E -> Log.e(name, message(), e)
        }
    }

    override fun e(message: String) {
        when (option.levelOverwrite[E]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message)
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message)
            }

            I -> Log.i(name, message)
            W -> Log.w(name, message)
            null,
            E -> Log.e(name, message)
        }
    }

    override fun e(message: () -> String) {
        when (option.levelOverwrite[E]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message())
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message())
            }

            I -> Log.i(name, message())
            W -> Log.w(name, message())
            null,
            E -> Log.e(name, message())
        }
    }

    override fun e(message: String, e: Throwable) {
        when (option.levelOverwrite[E]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message, e)
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message, e)
            }

            I -> Log.i(name, message, e)
            W -> Log.w(name, message, e)
            null,
            E -> Log.e(name, message, e)
        }
    }

    override fun e(message: () -> String, e: Throwable) {
        when (option.levelOverwrite[E]) {
            V -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.VERBOSE)) {
                Log.v(name, message(), e)
            }

            D -> if (ModuleConfig.DEBUG || Log.isLoggable(name, Log.DEBUG)) {
                Log.d(name, message(), e)
            }

            I -> Log.i(name, message(), e)
            W -> Log.w(name, message(), e)
            null,
            E -> Log.e(name, message(), e)
        }
    }
}
