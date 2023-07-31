package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.baseInteraction
import com.github.hemoptysisheart.parking.app.interaction.main.RouteNavigationInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
fun RouteNavigationPage(interaction: RouteNavigationInteraction) {
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
        EasyButton(onClick = { /*TODO*/ }, label = "안내 종료")
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_RouteNavigationPage() {
    ParkingTheme {
        RouteNavigationPage(RouteNavigationInteraction(baseInteraction(PreviewActivity())))
    }
}
