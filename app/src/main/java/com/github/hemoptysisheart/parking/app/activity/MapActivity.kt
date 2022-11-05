package com.github.hemoptysisheart.parking.app.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.component.map.MapView
import com.github.hemoptysisheart.parking.app.ui.config.LogicConstants.TAG_COMPOSE
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * 기본 액티비티.
 *
 * 지도 화면 등.
 */
@AndroidEntryPoint
class MapActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParkingTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MapLayout()
                }
            }
        }
    }
}

@Composable
fun MapLayout() {
    Log.v(TAG_COMPOSE, "#MapLayout called.")

    MapView()
}

@Preview(showBackground = true)
@Composable
fun MapLayoutPreview() {
    ParkingTheme {
        MapLayout()
    }
}
