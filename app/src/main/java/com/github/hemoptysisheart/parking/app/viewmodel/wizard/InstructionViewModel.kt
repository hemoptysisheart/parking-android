package com.github.hemoptysisheart.parking.app.viewmodel.wizard

import androidx.lifecycle.LifecycleOwner
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.domain.app.WizardPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class InstructionViewModel @Inject constructor(
        wizardPreferences: WizardPreferences,
        private val locationModel: LocationModel
) : BaseViewModel() {
    private val _closable = MutableStateFlow(locationModel.granted)
    val closeable: StateFlow<Boolean> = _closable

    init {
        wizardPreferences.increaseShowCount()
        wizardPreferences.bootUpShow = false
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        launch {
            _closable.emit(locationModel.granted)
        }
    }
}
