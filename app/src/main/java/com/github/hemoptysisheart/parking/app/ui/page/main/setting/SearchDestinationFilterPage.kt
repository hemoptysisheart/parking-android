package com.github.hemoptysisheart.parking.app.ui.page.main.setting

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.baseInteraction
import com.github.hemoptysisheart.parking.app.interaction.main.SearchDestinationFilterInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
fun SearchDestinationFilterPage(interaction: SearchDestinationFilterInteraction) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = """
                - 검색 반경
                - 검색 결과 없을 때 재검색 여부
            """.trimIndent(),
            modifier = Modifier.fillMaxWidth()
        )

        EasyButton(onClick = interaction::goBack, label = "닫기")
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_SearchDestinationFilterPage() {
    ParkingTheme {
        SearchDestinationFilterPage(SearchDestinationFilterInteraction(baseInteraction(PreviewActivity())))
    }
}
