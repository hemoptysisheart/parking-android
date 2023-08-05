package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.main.SearchSettingInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPage

@Composable
fun SearchSettingPage(
    interaction: SearchSettingInteraction
) {
    LOGGER.v("#SearchSettingPage args : interaction=$interaction")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = """
                - 목적직 검색 반경
                - 주차장 검색 반경
                - 검색 언어
                - 검색 결과 없을 때 재검색 여부
            """.trimIndent(),
            modifier = Modifier.fillMaxWidth()
        )

        EasyButton(onClick = interaction::goBack, label = "닫기")
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_SearchSettingPage() {
    PreviewPage {
        SearchSettingPage(SearchSettingInteraction(it))
    }
}
