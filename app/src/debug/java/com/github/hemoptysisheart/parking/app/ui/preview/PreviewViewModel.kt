package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.app.ui.preview.PreviewModel.LOCATION_MODEL
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewModel.PLACE_MODEL
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel

object PreviewViewModel {
    val MAIN_VM = MainViewModel(LOCATION_MODEL, PLACE_MODEL)
}