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
import com.github.hemoptysisheart.parking.app.interaction.main.SettingsInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer

/**
 * `main/settings`
 *
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54310-34798&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54406-992&mode=design
 */
@Composable
fun SettingsPageContent(interaction: SettingsInteraction) {
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
        EasyButton(onClick = interaction::gotoSearchSetting, label = "검색 설정")
        EasyButton(onClick = interaction::gotoWizard, label = "마법사")
        EasyButton(onClick = interaction::gotoDeveloperSetting, label = "개발자 설정")
    }
}


@Composable
@PagePreview
fun Preview_SettingsPageContent() {
    PagePreviewContainer {
        SettingsPageContent(SettingsInteraction(it))
    }
}
