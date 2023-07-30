package com.github.hemoptysisheart.parking.app.ui.page.wizard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.baseInteraction
import com.github.hemoptysisheart.parking.app.interaction.wizard.LocationInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.ui.theme.Typography

@Composable
fun LocationPage(interaction: LocationInteraction) {
    Column(Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.weight(1F))
        Text(
            text = """
                1. 위치정보 권한을 요청한다.
                2. 위치정보를 얻지 못한 경우, 앱 설정으로 안내한다.
                3. 마법사를 종료한다.
                """.trimIndent(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            style = Typography.bodyLarge
        )
        EasyButton(onClick = interaction::requestPermission, label = "시스템 위치 권한 요청")
        EasyButton(onClick = interaction::openAppSetting, label = "앱 설정 열기")
        EasyButton(onClick = interaction::close, label = "마법사 종료")
        Spacer(modifier = Modifier.weight(1F))
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_LocationPage() {
    ParkingTheme {
        LocationPage(LocationInteraction(baseInteraction(PreviewActivity())))
    }
}
