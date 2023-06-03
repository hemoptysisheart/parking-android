package com.github.hemoptysisheart.parking.app.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.hemoptysisheart.parking.app.ui.interaction.SearchInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewViewModel.SEARCH_VM
import com.github.hemoptysisheart.parking.app.ui.preview.commonInteraction
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER
import com.github.hemoptysisheart.parking.app.ui.template.search.SearchHeaderTemplate
import com.github.hemoptysisheart.parking.app.ui.template.search.SearchResultTemplate
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.viewmodel.SearchViewModel

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun SearchPage(
    interaction: SearchInteraction,
    viewModel: SearchViewModel = hiltViewModel()
) {
    LOGGER.v("#SearchPage args : interaction=$interaction, viewModel=$viewModel")

    val query by viewModel.query.collectAsStateWithLifecycle()
    val resultList by viewModel.resultList.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SearchHeaderTemplate(query, viewModel.onQueryChange, interaction.onBack)
        SearchResultTemplate(viewModel.here, resultList, interaction.hideSoftwareKeyboard, interaction.gotoSelectRoute)
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview_SearchPage() {
    ParkingTheme {
        SearchPage(
            SearchInteraction(commonInteraction()),
            SEARCH_VM
        )
    }
}
