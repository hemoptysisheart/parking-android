package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.hemoptysisheart.parking.app.ui.interaction.main.SearchDestinationPageInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.SEARCH_VM
import com.github.hemoptysisheart.parking.app.ui.preview.commonInteraction
import com.github.hemoptysisheart.parking.app.ui.template.search.SearchHeaderTemplate
import com.github.hemoptysisheart.parking.app.ui.template.search.SearchResultTemplate
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.viewmodel.SearchViewModel
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_COMPOSE as LOGGER

/**
 * [목적지 검색 화면](https://www.figma.com/file/I3LN6lcAVaAXlNba0kBKPN/Parking?type=design&node-id=112-509&mode=design)
 */
@Composable
fun SearchDestinationPage(
    interaction: SearchDestinationPageInteraction,
    viewModel: SearchViewModel = hiltViewModel()
) {
    LOGGER.v("#SearchDestinationPage args : interaction=$interaction, viewModel=$viewModel")

    val query by viewModel.query.collectAsStateWithLifecycle()
    val resultList by viewModel.resultList.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SearchHeaderTemplate(query, viewModel.onQueryChange, interaction::onBack)
        SearchResultTemplate(
            viewModel.here,
            resultList,
            interaction::hideSoftwareKeyboard,
            interaction::gotoSelectRoute
        )
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview_SearchDestinationPage() {
    ParkingTheme {
        SearchDestinationPage(
            SearchDestinationPageInteraction(commonInteraction()),
            SEARCH_VM
        )
    }
}
