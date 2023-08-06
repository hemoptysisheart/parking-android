package com.github.hemoptysisheart.parking.core.util

import android.util.Log
import com.github.hemoptysisheart.parking.core.util.AndroidLogger.Level.*
import kotlin.reflect.KClass

class AndroidLogger(
        val name: String
) {
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

    init {
        when {
            name.isEmpty() ->
                throw IllegalArgumentException("name is empty.")

            !name.matches(NAME_REGEX) ->
                throw IllegalArgumentException("illegal name : name='$name', PATTERN='$NAME_PATTERN'")
        }
    }

    fun v(message: String) = when (option.levelOverwrite[V]) {
        null,
        V -> Log.v(name, message)

        D -> Log.d(name, message)
        I -> Log.i(name, message)
        W -> Log.w(name, message)
        E -> Log.e(name, message)
    }

    fun v(message: String, e: Throwable) = when (option.levelOverwrite[V]) {
        null,
        V -> Log.v(name, message, e)

        D -> Log.d(name, message, e)
        I -> Log.i(name, message, e)
        W -> Log.w(name, message, e)
        E -> Log.e(name, message, e)
    }

    fun d(message: String) = when (option.levelOverwrite[D]) {
        V -> Log.v(name, message)
        null,
        D -> Log.d(name, message)

        I -> Log.i(name, message)
        W -> Log.w(name, message)
        E -> Log.e(name, message)
    }

    fun d(message: String, e: Throwable) = when (option.levelOverwrite[D]) {
        V -> Log.v(name, message, e)
        null,
        D -> Log.d(name, message, e)

        I -> Log.i(name, message, e)
        W -> Log.w(name, message, e)
        E -> Log.e(name, message, e)
    }

    fun i(message: String) = when (option.levelOverwrite[I]) {
        V -> Log.v(name, message)
        D -> Log.d(name, message)
        null,
        I -> Log.i(name, message)

        W -> Log.w(name, message)
        E -> Log.e(name, message)
    }

    fun i(message: String, e: Throwable) = when (option.levelOverwrite[I]) {
        V -> Log.v(name, message, e)
        D -> Log.d(name, message, e)
        null,
        I -> Log.i(name, message, e)

        W -> Log.w(name, message, e)
        E -> Log.e(name, message, e)
    }

    fun w(message: String) = when (option.levelOverwrite[W]) {
        V -> Log.v(name, message)
        D -> Log.d(name, message)
        I -> Log.i(name, message)
        null,
        W -> Log.w(name, message)

        E -> Log.e(name, message)
    }

    fun w(message: String, e: Throwable) = when (option.levelOverwrite[W]) {
        V -> Log.v(name, message, e)
        D -> Log.d(name, message, e)
        I -> Log.i(name, message, e)
        null,
        W -> Log.w(name, message, e)

        E -> Log.e(name, message, e)
    }

    fun e(message: String) = when (option.levelOverwrite[E]) {
        V -> Log.v(name, message)
        D -> Log.d(name, message)
        I -> Log.i(name, message)
        W -> Log.w(name, message)
        null,
        E -> Log.e(name, message)
    }

    fun e(message: String, e: Throwable) = when (option.levelOverwrite[E]) {
        V -> Log.v(name, message, e)
        D -> Log.d(name, message, e)
        I -> Log.i(name, message, e)
        W -> Log.w(name, message, e)
        null,
        E -> Log.e(name, message, e)
    }
}
