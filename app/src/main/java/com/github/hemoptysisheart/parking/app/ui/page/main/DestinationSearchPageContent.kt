package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.main.DestinationSearchInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.Divider
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.search.Header
import com.github.hemoptysisheart.parking.app.ui.template.search.RecommendItem
import com.github.hemoptysisheart.parking.domain.search.RecommendItem

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
        recommendItemList: List<RecommendItem<*>>,
        onChangeQuery: (String) -> Unit = { }
) {
    LOGGER.v("#DestinationSearchPageContent args : query=$query, recommendItemList=$recommendItemList")

    Column(Modifier.fillMaxSize()) {
        Header(
                query = query,
                onChangeQuery = onChangeQuery,
                onClickBack = interaction::goBack,
                gotoSearchSetting = interaction::gotoSearchSetting
        )

        LazyColumn(Modifier.fillMaxSize()) {
            when {
                query.isEmpty() && recommendItemList.isEmpty() -> // 초기 상태
                    item {
                        Text(text = "초기상태")
                    }

                query.isNotEmpty() && recommendItemList.isEmpty() -> // 검색 결과 없음
                    item {
                        Text(text = "결과가 없습니다.")
                    }

                else -> // 검색 결과 있음.
                    itemsIndexed(recommendItemList) { idx, item ->
                        if (0 < idx) {
                            Divider()
                        }
                        RecommendItem(item = item, gotoSelectParking = interaction::gotoSelectParking)
                    }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun Preview_DestinationSearchPageContent() {
    PagePreviewContainer {
        DestinationSearchPageContent(
                interaction = DestinationSearchInteraction(it),
                query = "검색어 검색어 검색어",
                recommendItemList = emptyList()
        )
    }
}
