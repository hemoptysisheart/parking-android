package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.interaction.main.DeveloperSettingInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.setting.Header

@Composable
fun DeveloperSettingPage(
        interaction: DeveloperSettingInteraction
) {
    LOGGER.v("#DeveloperSettingPage args : interaction=$interaction")

    Header(title = R.string.page_developer_setting_title, onClickBack = interaction::goBack)
    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
            verticalArrangement = Arrangement.Center
    ) {
        Text(
                text = """
                - GMP 키 변경
                - Install 설정 정보
            """.trimIndent()
        )

        EasyButton(onClick = interaction::goBack, label = "돌아가기")
    }
}

@Composable
@PagePreview
fun Preview_DeveloperSettingPage() {
    PagePreviewContainer {
        DeveloperSettingPage(DeveloperSettingInteraction(it))
    }
}
