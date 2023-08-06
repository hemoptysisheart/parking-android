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
import com.github.hemoptysisheart.parking.app.interaction.main.SettingInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPage

@Composable
fun SettingPage(interaction: SettingInteraction) {
    LOGGER.v("#SettingPage args : interaction=$interaction")

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
            verticalArrangement = Arrangement.Center
    ) {
        Text(
                text = """
                각종 설정.
                
                - 목적지 검색 기본 필터.
                - GMP 키 설정.
                - 실행 기록.
                - 앱 정보.
            """.trimIndent(),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
        )

        EasyButton(onClick = interaction::goBack, label = "돌아가기")
        EasyButton(onClick = interaction::gotoSearchDestinationFilter, label = "목적지 검색 필터")
        EasyButton(onClick = interaction::gotoWizard, label = "마법사")
        EasyButton(onClick = interaction::gotoDeveloperSetting, label = "개발자 설정")
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_SettingPage() {
    PreviewPage {
        SettingPage(SettingInteraction(it))
    }
}
