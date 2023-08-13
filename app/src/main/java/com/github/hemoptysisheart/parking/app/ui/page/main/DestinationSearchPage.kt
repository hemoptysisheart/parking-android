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
import com.github.hemoptysisheart.parking.app.interaction.main.DestinationSearchInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.main.DestinationSearchViewModel

/**
 * 목적지 검색
 *
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-653
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54311-34835&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54416-1445&mode=design
 */
@Composable
fun DestinationSearchPage(
        interaction: DestinationSearchInteraction,
        viewModel: DestinationSearchViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#DestinationSearchPage args : interaction=$interaction")
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
@PagePreview
fun Preview_DestinationSearchPage() {
    PagePreviewContainer {
        DestinationSearchPage(DestinationSearchInteraction(it))
    }
}
