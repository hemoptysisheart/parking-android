package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.baseInteraction
import com.github.hemoptysisheart.parking.app.interaction.main.SelectParingInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
fun SelectParkingPage(interaction: SelectParingInteraction) {
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
        EasyButton(onClick = interaction::gotoRouteNavigation, label = "안내 시작")
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_SelectParkingPage() {
    ParkingTheme {
        SelectParkingPage(SelectParingInteraction(baseInteraction(PreviewActivity())))
    }
}
