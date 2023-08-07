package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.main.SelectParkingInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer

/**
 * [주차장 선택](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-673)
 */
@Composable
fun SelectParkingPage(interaction: SelectParkingInteraction) {
    LOGGER.v("#SelectParkingPage args : interaction=$interaction")

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
            verticalArrangement = Arrangement.Center
    ) {
        Text(
                text = """
                - 목적지 근처 지도
                    - 목적지
                    - 후보 주차장
                    - 경로
                - 현재 선택한 주차장 상세 정보
            """.trimIndent(),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
        )

        EasyButton(onClick = interaction::goBack, label = "돌아가기")
        EasyButton(onClick = { /*TODO*/ }, label = "주차장(경로) 선택")
        EasyButton(onClick = interaction::gotoSelectRoute, label = "경로 선택")
    }
}

@Composable
@PagePreview
fun Preview_SelectParkingPage() {
    PagePreviewContainer {
        SelectParkingPage(SelectParkingInteraction(it))
    }
}