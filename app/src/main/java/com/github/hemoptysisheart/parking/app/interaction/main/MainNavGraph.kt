package com.github.hemoptysisheart.parking.app.interaction.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction

@Composable
fun MainNavGraph(baseInteraction: BaseInteraction) {
    Text(text = "$baseInteraction")
}
