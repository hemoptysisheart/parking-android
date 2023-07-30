package com.github.hemoptysisheart.util

interface Logger {
    fun v(message: String)
    fun v(message: () -> String)
    fun v(message: String, e: Throwable)
    fun v(message: () -> String, e: Throwable)

    fun d(message: String)
    fun d(message: () -> String)
    fun d(message: String, e: Throwable)
    fun d(message: () -> String, e: Throwable)

    fun i(message: String)
    fun i(message: () -> String)
    fun i(message: String, e: Throwable)
    fun i(message: () -> String, e: Throwable)

    fun w(message: String)
    fun w(message: () -> String)
    fun w(message: String, e: Throwable)
    fun w(message: () -> String, e: Throwable)

    fun e(message: String)
    fun e(message: () -> String)
    fun e(message: String, e: Throwable)
    fun e(message: () -> String, e: Throwable)
}