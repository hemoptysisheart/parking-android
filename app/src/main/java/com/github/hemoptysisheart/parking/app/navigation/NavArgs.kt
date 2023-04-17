package com.github.hemoptysisheart.parking.app.navigation

import androidx.lifecycle.SavedStateHandle

/**
 * 탑색 인자 추출하기.
 */
fun interface NavArgs<A> {
    operator fun invoke(handle: SavedStateHandle): A
}
