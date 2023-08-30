package com.github.hemoptysisheart.parking.app.viewmodel.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.app.interaction.main.RouteNavigationInteraction
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.model.RouteModel
import com.github.hemoptysisheart.parking.domain.route.SubRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import javax.inject.Inject

/**
 * 경로 안내
 *
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-693
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54312-34862&mode=design
 */
@HiltViewModel
@OptIn(ExperimentalCoroutinesApi::class)
class RouteNavigationViewModel @Inject constructor(
        savedStateHandle: SavedStateHandle,
        private val routeModel: RouteModel
) : BaseViewModel() {
    final lateinit var drive: SubRoute
        private set

    final lateinit var walk: SubRoute
        private set

    init {
        val args = RouteNavigationInteraction.args(savedStateHandle)
        viewModelScope.async {
            drive = routeModel.read(args.drive)
                    ?: throw IllegalArgumentException("route does not exist : id=${args.drive}")
            walk = routeModel.read(args.walk)
                    ?: throw IllegalArgumentException("route does not exist : id=${args.walk}")
        }.getCompleted()
        logger.d("#init complete.")
    }
}
