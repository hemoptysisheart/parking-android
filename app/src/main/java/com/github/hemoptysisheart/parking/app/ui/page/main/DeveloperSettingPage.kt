package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.main.DeveloperSettingInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPage

@Composable
fun DeveloperSettingPage(
    interaction: DeveloperSettingInteraction
) {
    LOGGER.v("#DeveloperSettingPage args : interaction=$interaction")

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
@Preview(showSystemUi = true)

fun Preview_DeveloperSettingPage() {
    PreviewPage {
        DeveloperSettingPage(DeveloperSettingInteraction(it))
    }
}
