package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.main.SelectRouteInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPage

/**
 * [경로 선택](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-681)
 */
@Composable
fun SelectRoutePage(
    interaction: SelectRouteInteraction
) {
    LOGGER.v("#SelectRoutePage args : interaction=$interaction")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = """
                주차장을 거쳐가는 경로를 비교해보고 선택할 수 있다.
            """.trimIndent(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        EasyButton(onClick = interaction::goBack, label = "돌아가기")
        EasyButton(onClick = interaction::gotoRouteNavigation, label = "안내 시작")
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_SelectRoutePage() {
    PreviewPage {
        SelectRoutePage(SelectRouteInteraction(it))
    }
}