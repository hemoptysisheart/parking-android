package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.baseInteraction
import com.github.hemoptysisheart.parking.app.interaction.main.DestinationSearchInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

/**
 * [목적지 검색](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-653)
 */
@Composable
fun DestinationSearchPage(interaction: DestinationSearchInteraction) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = """
                - 검색어 입력창
                - 추천 항목
                - 검색 결과
            """.trimIndent(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        EasyButton(onClick = interaction::goBack, label = "돌아가기")
        EasyButton(onClick = interaction::gotoDestinationSearchFilterSetting, label = "검색 필터")
        EasyButton(onClick = interaction::gotoSelectParking, label = "목적지 선택")
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_DestinationSearchPage() {
    ParkingTheme {
        DestinationSearchPage(DestinationSearchInteraction(baseInteraction(PreviewActivity())))
    }
}
