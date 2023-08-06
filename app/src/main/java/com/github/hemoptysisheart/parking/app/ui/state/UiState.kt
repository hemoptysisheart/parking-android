package com.github.hemoptysisheart.parking.app.ui.state

import androidx.compose.runtime.remember
import java.util.UUID

abstract class UiState {
    /**
     * 하나의 `@Composable` 함수 내에서 같은 유형의 [UiState]가 여럿 있으면서 [remember]를 사용할 때 `key`로 쓸 수 있는 값.
     */
    val key: UUID = UUID.randomUUID()
}