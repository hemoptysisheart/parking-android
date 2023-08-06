package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.main.RouteNavigationInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPage

/**
 * [경로 안내](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-693)
 */
@Composable
fun RouteNavigationPage(interaction: RouteNavigationInteraction) {
    LOGGER.v("#RouteNavigationPage args : interaction=$interaction")
    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
            verticalArrangement = Arrangement.Center
    ) {
        Text(
                text = """
                - 경로 지도
                    - 남은 구간
                    - 현재 위치
                - 경로 상세 정보
                - 현재 구간
                - 다음 구간
            """.trimIndent(),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
        )

        EasyButton(onClick = interaction::goBack, label = "돌아가기")
        EasyButton(onClick = interaction::closeRouteNavigation, label = "안내 종료")
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_RouteNavigationPage() {
    PreviewPage {
        RouteNavigationPage(RouteNavigationInteraction(it))
    }
}
