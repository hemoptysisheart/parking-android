package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.baseInteraction
import com.github.hemoptysisheart.parking.app.interaction.main.LandingMapInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
fun LandingMapPage(interaction: LandingMapInteraction) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = """
                지도, 현재 위치, 오버레이 표시.
                
                목적지를 선택했을 경우와 비슷한 오버레이를 활용해서 사용자에게 정보를 전달하고 다음 행동을 유도한다.
            """.trimIndent(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        EasyButton(onClick = interaction::gotoDestinationSearch, label = "목적지 검색")
        EasyButton(onClick = interaction::gotoSetting, label = "설정")
    }
}

@Composable
@Preview(showSystemUi = true)
fun LandingMapPage() {
    ParkingTheme {
        LandingMapPage(LandingMapInteraction(baseInteraction(PreviewActivity())))
    }
}
