package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GlobalHeaderViewModel @Inject constructor() : BaseViewModel() {
    companion object {
        private val LOGGER = AndroidLogger(GlobalHeaderViewModel::class)
    }

    val p = MutableStateFlow(false)

    init {
        viewModelScope.launch {
            for (i in 1..100) {
                delay(2000)
                p.emit(0 == i % 2)
            }
        }
    }
}
