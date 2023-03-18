package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.app.ui.preview.PreviewModel.GEO_SEARCH_MODEL
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewModel.LOCATION_MODEL
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.SearchViewModel

object PreviewViewModel {
    val MAIN_VM = MainViewModel(LOCATION_MODEL)
    val SEARCH_VM = SearchViewModel(LOCATION_MODEL, GEO_SEARCH_MODEL)
}