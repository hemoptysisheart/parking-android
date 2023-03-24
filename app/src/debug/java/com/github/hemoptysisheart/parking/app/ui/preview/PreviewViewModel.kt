package com.github.hemoptysisheart.parking.app.ui.preview

import androidx.lifecycle.SavedStateHandle
import com.github.hemoptysisheart.parking.app.navigation.SelectRoutePageNavigation
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewModel.GEO_SEARCH_MODEL
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewModel.LOCATION_MODEL
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.SearchViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.SelectRouteViewModel

object PreviewViewModel {
    val MAIN_VM = MainViewModel(LOCATION_MODEL)

    val SEARCH_VM = SearchViewModel(LOCATION_MODEL, GEO_SEARCH_MODEL)

    val SELECT_ROUTE_VM = SelectRouteViewModel(
        SavedStateHandle(
            mapOf(
                SelectRoutePageNavigation.PARAM_ID to LOCATION_株式会社ＡＡＡ.id
            )
        ),
        GEO_SEARCH_MODEL
    )
}