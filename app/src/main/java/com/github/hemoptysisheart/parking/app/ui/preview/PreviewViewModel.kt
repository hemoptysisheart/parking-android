package com.github.hemoptysisheart.parking.app.ui.preview

import androidx.compose.runtime.Composable
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.GlobalHeaderViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.main.SearchSettingViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.wizard.LocationViewModel
import com.github.hemoptysisheart.parking.core.model.GlobalChannelConsumer
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.util.TruncatedTimeProvider

@Composable
fun previewGlobalHeaderViewModel(
        globalChannelConsumer: GlobalChannelConsumer = previewGlobalChannelConsumer()
) = GlobalHeaderViewModel(globalChannelConsumer)

@Composable
fun previewBaseViewModel(): BaseViewModel {
    val vm = BaseViewModel()
    vm.timeProvider = TruncatedTimeProvider()
    vm.globalChannel = previewGlobalChannel()
    return vm
}

fun previewSearchSettingViewModel(
        searchPreferences: SearchPreferences = previewPreferencesModel().search
) = SearchSettingViewModel(searchPreferences)

fun previewLocationViewModel(
        locationModel: LocationModel = previewLocationModel(geolocation = Geolocation(0.0, 0.0))
) = LocationViewModel(locationModel)
