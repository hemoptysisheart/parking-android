package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.main.DestinationSearchInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.search.Header

/**
 * 목적지 검색
 *
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-653
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54311-34835&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54416-1445&mode=design
 *
 * @param interaction 목적지 검색 확면의 인터랙션.
 * @param query 검색어
 * @param onChangeQuery 검색어 입력 처리
 */
@Composable
fun DestinationSearchPageContent(
        interaction: DestinationSearchInteraction,
        query: String,
        onChangeQuery: (String) -> Unit = { }
) {
    Header(
            query = query,
            onChangeQuery = onChangeQuery,
            onClickBack = interaction::goBack,
            gotoSearchSetting = interaction::gotoSearchSetting
    )

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
            verticalArrangement = Arrangement.Center
    ) {

        EasyButton(onClick = interaction::gotoSelectParking, label = "목적지 선택")
    }
}


@Composable
@Preview(showSystemUi = true)
fun Preview_DestinationSearchPageContent() {
    PagePreviewContainer {
        DestinationSearchPageContent(
                interaction = DestinationSearchInteraction(it),
                query = "검색어 검색어 검색어"
        )
    }
}
