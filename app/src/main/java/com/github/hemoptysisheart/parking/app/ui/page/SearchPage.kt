package com.github.hemoptysisheart.parking.app.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.navigation.SearchPageNavigation
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewViewModel.SEARCH_VM
import com.github.hemoptysisheart.parking.app.ui.template.search.SearchHeaderTemplate
import com.github.hemoptysisheart.parking.app.ui.template.search.SearchResultTemplate
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.viewmodel.SearchViewModel
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_COMPOSE as LOGGER

@Composable
fun SearchPage(
    navigation: SearchPageNavigation = SearchPageNavigation(rememberNavController()),
    viewModel: SearchViewModel = hiltViewModel()
) {
    LOGGER.v("#SearchPage args : navigation=$navigation, viewModel=$viewModel")

    val query by viewModel.query.collectAsStateWithLifecycle()
    val resultList by viewModel.resultList.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SearchHeaderTemplate(query, viewModel.onQueryChange, navigation.onBack)
        SearchResultTemplate(viewModel.here, resultList, navigation.gotoSelectRoute)
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview_SearchPage() {
    ParkingTheme {
        SearchPage(viewModel = SEARCH_VM)
    }
}
