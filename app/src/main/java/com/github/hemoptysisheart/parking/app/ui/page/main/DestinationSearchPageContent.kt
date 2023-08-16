package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.interaction.main.DestinationSearchInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.Divider
import com.github.hemoptysisheart.parking.app.ui.molecule.TextTitleLarge
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.search.Header
import com.github.hemoptysisheart.parking.app.ui.template.search.RecommendItem
import com.github.hemoptysisheart.parking.domain.place.Place
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
 * @param showItemDetail 목적지 검색 결과 상세 보기
 */
@Composable
fun DestinationSearchPageContent(
        interaction: DestinationSearchInteraction,
        query: String,
        recommendItemList: List<RecommendItem<*>>?,
        onChangeQuery: (String) -> Unit = { },
        showItemDetail: (RecommendItem<*>) -> Unit = { }
) {
    LOGGER.v("#DestinationSearchPageContent args : query=$query, recommendItemList=$recommendItemList")

    Column(Modifier.fillMaxSize()) {
        Header(
                query = query,
                onChangeQuery = onChangeQuery,
                onClickBack = interaction::goBack,
                gotoSearchSetting = interaction::gotoSearchSetting
        )

        when {
            null == recommendItemList -> // 초기 상태
                DestinationSearchPageContentInit()

            recommendItemList.isEmpty() -> // 검색 결과 없음
                DestinationSearchPageContentEmpty()

            else ->  // 검색 결과 있음.
                DestinationSearchPageContentResult(recommendItemList, interaction::gotoSelectParking, showItemDetail)
        }
    }
}

/**
 * 화면 실행 초기 상태.
 */
@Composable
private fun DestinationSearchPageContentInit() {
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextTitleLarge(
                text = stringResource(R.string.page_destination_search_init_label),
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
        )
    }
}

/**
 * 검색 결과 없음.
 */
@Composable
private fun DestinationSearchPageContentEmpty() {
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextTitleLarge(
                text = stringResource(R.string.page_destination_search_no_result_label),
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
        )
    }
}

/**
 * 검색 결과.
 */
@Composable
private fun DestinationSearchPageContentResult(
        recommendItemList: List<RecommendItem<*>>,
        gotoSelectParking: (Place) -> Unit,
        showItemDetail: (RecommendItem<*>) -> Unit
) {
    LazyColumn(Modifier
            .fillMaxSize()
            .padding(0.dp, 20.dp)) {
        recommendItemList.forEachIndexed { index, item ->
            if (0 < index) {
                item { Divider() }
            }

            item {
                RecommendItem(item = item, gotoSelectParking = gotoSelectParking, showItemDetail = showItemDetail)
            }
        }
    }
}

@Composable
@PagePreview
//@Preview(showSystemUi = true)
fun Preview_DestinationSearchPageContentInit() {
    PagePreviewContainer {
        DestinationSearchPageContent(
                interaction = DestinationSearchInteraction(it),
                query = "",
                recommendItemList = emptyList()
        )
    }
}

@Composable
@PagePreview
//@Preview(showSystemUi = true)
fun Preview_DestinationSearchPageContentEmpty() {
    PagePreviewContainer {
        DestinationSearchPageContent(
                interaction = DestinationSearchInteraction(it),
                query = "결과 없음",
                recommendItemList = emptyList()
        )
    }
}

@Composable
@PagePreview
//@Preview(showSystemUi = true)
fun Preview_DestinationSearchPageContentResult() {
    PagePreviewContainer {
        DestinationSearchPageContent(
                interaction = DestinationSearchInteraction(it),
                query = "검색어 검색어",
                recommendItemList = emptyList() // TODO 데이터 추가
        )
    }
}
