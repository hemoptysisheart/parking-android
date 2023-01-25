package com.github.hemoptysisheart.parking.app.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewViewModel.MAIN_VM
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val here = viewModel.here
    Log.v(TAG_COMPOSE, "#MainScreen : here=${here.toSimpleString()}")

    Text(text = here.toSimpleString())
}

@SuppressLint("ComposableNaming")
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun preview_MainScreen() {
    ParkingTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            MainScreen(MAIN_VM)
        }
    }
}
