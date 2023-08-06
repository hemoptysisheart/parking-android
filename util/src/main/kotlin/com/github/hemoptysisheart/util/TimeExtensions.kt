package com.github.hemoptysisheart.util

import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.OffsetTime
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit.MILLIS

/**
 * milliseconds까지 남기기.
 * JVM에서 기본 자료형 하나(`long`)로 표현할 수 있는 가장 작은 시간 단위가 밀리세컨드이므로 밀리세컨드로 자름.
 */
fun Instant.truncateToMillis(): Instant = truncatedTo(MILLIS)

/**
 * milliseconds까지 남기기.
 * JVM에서 기본 자료형 하나(`long`)로 표현할 수 있는 가장 작은 시간 단위가 밀리세컨드이므로 밀리세컨드로 자름.
 */
fun ZonedDateTime.truncateToMillis(): ZonedDateTime = truncatedTo(MILLIS)

/**
 * milliseconds까지 남기기.
 * JVM에서 기본 자료형 하나(`long`)로 표현할 수 있는 가장 작은 시간 단위가 밀리세컨드이므로 밀리세컨드로 자름.
 */
fun OffsetDateTime.truncateToMillis(): OffsetDateTime = truncatedTo(MILLIS)

/**
 * milliseconds까지 남기기.
 * JVM에서 기본 자료형 하나(`long`)로 표현할 수 있는 가장 작은 시간 단위가 밀리세컨드이므로 밀리세컨드로 자름.
 */
fun OffsetTime.truncateToMillis(): OffsetTime = truncatedTo(MILLIS)

/**
 * milliseconds까지 남기기.
 * JVM에서 기본 자료형 하나(`long`)로 표현할 수 있는 가장 작은 시간 단위가 밀리세컨드이므로 밀리세컨드로 자름.
 */
fun LocalDateTime.truncateToMillis(): LocalDateTime = truncatedTo(MILLIS)

/**
 * milliseconds까지 남기기.
 * JVM에서 기본 자료형 하나(`long`)로 표현할 수 있는 가장 작은 시간 단위가 밀리세컨드이므로 밀리세컨드로 자름.
 */
fun LocalTime.truncateToMillis(): LocalTime = truncatedTo(MILLIS)
