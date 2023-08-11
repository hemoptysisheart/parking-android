package com.github.hemoptysisheart.parking.app.viewmodel.wizard

import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.app.WizardPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InstructionViewModel @Inject constructor(
        wizardPreferences: WizardPreferences
) : BaseViewModel() {
    companion object {
        private val LOGGER = AndroidLogger(InstructionViewModel::class)
    }

    init {
        wizardPreferences.increaseShowCount()
        wizardPreferences.bootUpShow = false
    }
}
