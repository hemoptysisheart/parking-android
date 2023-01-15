package com.github.hemoptysisheart.parking.core.model.support

import com.github.hemoptysisheart.util.TimeProvider
import com.github.hemoptysisheart.util.TruncatedTimeProvider
import org.apache.commons.lang3.RandomStringUtils
import java.util.concurrent.ThreadLocalRandom

val RANDOM: ThreadLocalRandom = ThreadLocalRandom.current()

val TIME_PROVIDER: TimeProvider = TruncatedTimeProvider()

/**
 * 지정한 범위에서 임의의 길이의 임의의 문자열을 반환한다.
 *
 * @param minLength 최소 길이. inclusive.
 * @param maxLength 최대 길이. exclusive.
 */
fun randomString(minLength: Int, maxLength: Int): String {
    if (minLength >= maxLength) {
        throw IllegalArgumentException("illegal length : minLength=$minLength, maxLength=$maxLength")
    }

    return RandomStringUtils.random(RANDOM.nextInt(minLength, maxLength))
}
