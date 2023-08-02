package com.github.hemoptysisheart.parking.app.interaction.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.ProgressIndicator

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MainScaffold(baseInteraction: BaseInteraction) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ProgressIndicator() }
    ) {
        MainNavGraph(baseInteraction)
    }
}
